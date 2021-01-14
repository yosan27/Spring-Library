package com.Faraday.Library.controllers;

import com.Faraday.Library.dto.BookDetailsDto;
import com.Faraday.Library.dto.StatusMessageDto;
import com.Faraday.Library.entity.BookDetailsEntity;
import com.Faraday.Library.services.BookDetailsServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BookDetailsController {

    @Autowired
    private BookDetailsServiceImplement service;

    @SuppressWarnings("rawtypes")
	private StatusMessageDto result = new StatusMessageDto();

    @SuppressWarnings("unchecked")
	@GetMapping("/bookdetails")
    public ResponseEntity<?> getAllDetails() {
        try {
            List<BookDetailsEntity> books = service.getAllDetailBooks();
            if (books.size() == 0) {
                result.setStatus(HttpStatus.BAD_REQUEST.value());
                result.setMessage("Data not found");
                result.setData(null);
                return ResponseEntity.badRequest().body(result);
            } else {
                result.setStatus(200);
                result.setMessage("Success");
                result.setData(books);
                return ResponseEntity.ok(result);
            }
        } catch (Exception e) {
            @SuppressWarnings("rawtypes")
			StatusMessageDto error = new StatusMessageDto(500, e.getMessage(), null);
            return ResponseEntity.status(500).body(error);
        }
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/lastbookdetail")
    public ResponseEntity<?> getLastBookDetail() {
        try {
            List<BookDetailsEntity> books = service.getLastBookDetail();
            if (books.size() == 0) {
                result.setStatus(HttpStatus.BAD_REQUEST.value());
                result.setMessage("Data not found");
                result.setData(null);
                return ResponseEntity.badRequest().body(result);
            } else {
                result.setStatus(200);
                result.setMessage("Success");
                result.setData(books);
                return ResponseEntity.ok(result);
            }
        } catch (Exception e) {
            @SuppressWarnings("rawtypes")
            StatusMessageDto error = new StatusMessageDto(500, e.getMessage(), null);
            return ResponseEntity.status(500).body(error);
        }
    }

    @SuppressWarnings("unchecked")
	@GetMapping("/bookdetails/{bookDetailCode}")
    public ResponseEntity<?> getDetailBook(@PathVariable String bookDetailCode) {
        try {
            BookDetailsEntity books = service.getDetailBooks(bookDetailCode);
            if (bookDetailCode == null) {
                result.setStatus(HttpStatus.BAD_REQUEST.value());
                result.setMessage("Data not found");
                result.setData(null);
                return ResponseEntity.badRequest().body(result);
            } else {
                result.setStatus(200);
                result.setMessage("Success");
                result.setData(books);
                return ResponseEntity.ok(result);
            }
        } catch (Exception e) {
            @SuppressWarnings("rawtypes")
			StatusMessageDto error = new StatusMessageDto(500, e.getMessage(), null);
            return ResponseEntity.status(500).body(error);
        }
    }

    @SuppressWarnings("unchecked")
	@PostMapping("/bookdetails")
    public ResponseEntity<?> post(@RequestBody BookDetailsDto dto){
        try {

            BookDetailsEntity books = service.post(dto);

            if (dto.getBookTitle() == null) {
                result.setStatus(HttpStatus.BAD_REQUEST.value());
                result.setMessage("Judul buku tidak boleh kosong");
                result.setData(null);
                return ResponseEntity.badRequest().body(result);
            } else {
                result.setStatus(200);
                result.setMessage("Success");
                result.setData(books);
                return ResponseEntity.ok(result);
            }
        } catch (Exception e) {
            @SuppressWarnings("rawtypes")
			StatusMessageDto error = new StatusMessageDto(500, e.getMessage(), null);
            return ResponseEntity.status(500).body(error);
        }
    }

    @SuppressWarnings("unchecked")
	@PutMapping("/bookdetails/{BookDetailCode}")
    public ResponseEntity<?> put(@PathVariable String BookDetailCode, @RequestBody BookDetailsDto dto){
        try {

            BookDetailsEntity books = service.put(BookDetailCode, dto);

            if (dto.getBookDetailCode() == null) {
                result.setStatus(HttpStatus.BAD_REQUEST.value());
                result.setMessage("Kode detail buku tidak boleh kosong");
                result.setData(null);
                return ResponseEntity.badRequest().body(result);
            } else {
                result.setStatus(200);
                result.setMessage("Success");
                result.setData(books);
                return ResponseEntity.ok(result);
            }
        } catch (Exception e) {
            @SuppressWarnings("rawtypes")
			StatusMessageDto error = new StatusMessageDto(500, e.getMessage(), null);
            return ResponseEntity.status(500).body(error);
        }
    }

    //Soft delete detail buku
    @SuppressWarnings("unchecked")
	@DeleteMapping("/bookdetails/{BookDetailCode}")
    public ResponseEntity<?> deleteDetailbook(@PathVariable String BookDetailCode) {
        try {
            BookDetailsEntity books = service.delete(BookDetailCode);

            if ( books == null) {
                result.setStatus(400);
                result.setMessage("Data not found");
                result.setData(books);

                return ResponseEntity.status(400).body(result);
            }

            result.setStatus(200);
            result.setMessage("deleted");
            result.setData(books);

            return ResponseEntity.status(200).body(result);
        } catch (Exception e) {
            @SuppressWarnings("rawtypes")
			StatusMessageDto error = new StatusMessageDto(500,e.getMessage(), null);
            return ResponseEntity.status(500).body(error);
        }
    }

}
