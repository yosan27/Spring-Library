package com.Faraday.Library.controllers;

import com.Faraday.Library.dto.UploadFileResponse;
import com.Faraday.Library.services.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private final UploadService uploadService;

    public FileController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/uploadFile/{newFileName}")
    public UploadFileResponse uploadFileResponse (@RequestParam("file") MultipartFile file, @PathVariable String newFileName){
        String fileName = uploadService.storeFile(file, newFileName);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/getFile/")
                .path(fileName)
                .toUriString();
        String message = "Success upload file";
        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize(), message);
    }

//    @PostMapping("/uploadMultipleFiles")
//    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFileResponse(file))
//                .collect(Collectors.toList());
//    }

    @GetMapping("/getFile/{fileName:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = uploadService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }

    @DeleteMapping("/deleteFile/{fileName:.+}")
    public ResponseEntity<?> deleteFile(@PathVariable String fileName) {
        // Load file as Resource
        Resource resource = uploadService.loadFileAsResource(fileName);
        try {
            // Delete file or directory
            Files.deleteIfExists(Paths.get(resource.getURI()));
            return ResponseEntity.ok("File "+fileName+" deleted successfully");
        } catch (NoSuchFileException ex) {
            return ResponseEntity.badRequest().body("No such file or directory: "+ fileName);
        } catch (DirectoryNotEmptyException ex) {
            return ResponseEntity.badRequest().body("Directory is not empty: "+ fileName);
        } catch (IOException ex) {
            return ResponseEntity.badRequest().body(ex);
        }
    }
}
