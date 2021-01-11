package com.Faraday.Library.controllers;

import com.Faraday.Library.dto.AddBookDto;
import com.Faraday.Library.dto.BookDto;
import com.Faraday.Library.dto.FineDto;
import com.Faraday.Library.dto.StatusMessageDto;
import com.Faraday.Library.entity.*;
import com.Faraday.Library.exception.ResourceNotFoundException;
import com.Faraday.Library.services.BookServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookServiceImplement service;

    @SuppressWarnings("rawtypes")
    private StatusMessageDto result = new StatusMessageDto();

    @SuppressWarnings("unchecked")
    @GetMapping("/books")
    public ResponseEntity<?> getAll() {
        try {
            List<BookEntity> books = service.getBooks();
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
    @GetMapping("/catalog")
    public ResponseEntity<?> getCatalog() {
        try {
            List<BookEntity> books = service.getCatalog();
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
    @GetMapping("/popular/{categoryCode}")
    public ResponseEntity<?> getPopular(@PathVariable String categoryCode) {
        try {
            List<BookEntity> books = service.getPopular(categoryCode);
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
    @GetMapping("/book/detailcode/{detailcode}")
    public ResponseEntity<?> getBookByDetailCode(@PathVariable String detailcode){
    	 try {
             BookEntity books = service.getBookByBookDetailCode(detailcode);
             if (books == null) {
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
    @GetMapping("/book/{bookCode}")
    public ResponseEntity<?> getBook(@PathVariable String bookCode) {
        try {
            BookEntity books = service.getBook(bookCode);
            if (bookCode == null) {
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
    @GetMapping("/detailBook/{id}")
    public ResponseEntity<?> getBookDetails(@PathVariable Integer id) { 
           BookEntity books = service.getBookDetails(id);
            return ResponseEntity.ok(books);
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/book")
    public ResponseEntity<?> post(@RequestBody BookDto dto){
        try {

            BookEntity books = service.post(dto);

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

    //post mapping all new
    @SuppressWarnings("unchecked")
    @PostMapping("/newbook")
    public ResponseEntity<?> postNew(@RequestBody AddBookDto dto){

        try {

            BookEntity books = service.postNew(dto);

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

    @PostMapping("/newbooks")
    BookEntity post(@RequestBody AddBookDto dto) {
        return service.postNew(dto);
    }

    @SuppressWarnings("unchecked")
    @PutMapping("/book/{BookCode}")
    public ResponseEntity<?> put(@PathVariable String BookCode, @RequestBody BookDto dto){
        try {

            BookEntity books = service.put(BookCode, dto);

            if (dto.getBookCode() == null) {
                result.setStatus(HttpStatus.BAD_REQUEST.value());
                result.setMessage("Kode buku tidak boleh kosong");
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
    
    @PutMapping("/book/status/{bookCode}")
    public ResponseEntity<?> updateStatus(@PathVariable String bookCode, @RequestBody BookDto dto) throws ResourceNotFoundException {
    	try {
    		return ResponseEntity.ok(service.updateStatus(bookCode, dto));
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resource With Book Code : " + bookCode + " Not Found!");
		}
    }

    //Soft delete detail buku
    @SuppressWarnings("unchecked")
    @DeleteMapping("/book/{BookCode}")
    public ResponseEntity<?> deleteBook(@PathVariable String BookCode) {
        try {
            BookEntity books = service.delete(BookCode);

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
