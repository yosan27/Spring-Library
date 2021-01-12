package com.Faraday.Library.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    String storeFile(MultipartFile file);
    Resource loadFileAsResource(String fileName);
}
