package com.Faraday.Library.controllers;

import java.util.List;

import com.Faraday.Library.dto.BookDetailsDto;
import com.Faraday.Library.dto.StatusMessageDto;
import com.Faraday.Library.entity.BookDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Faraday.Library.services.AuthorServiceImplement;
import com.Faraday.Library.dto.AuthorDto;
import com.Faraday.Library.entity.AuthorEntity;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AuthorController {

	@Autowired
	AuthorServiceImplement service;

	@SuppressWarnings("rawtypes")
	private StatusMessageDto result = new StatusMessageDto();

	@GetMapping("/author")
	List<AuthorEntity> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/author/active")
	public ResponseEntity<?> getActiveId() {
		return ResponseEntity.ok(service.getActiveId());
	}
	
	@GetMapping("/author/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.getById(id));
	}

//	@PostMapping("/author")
//	AuthorEntity post(@PathVariable AuthorDto dto) {
//		return service.post(dto);
//	}

	@SuppressWarnings("unchecked")
	@PostMapping("/author")
	public ResponseEntity<?> post(@RequestBody AuthorDto dto){
		try {

			AuthorEntity author = service.post(dto);

			if (dto.getAuthorName() == null) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
				result.setMessage("Nama penulis tidak boleh kosong");
				result.setData(null);
				return ResponseEntity.badRequest().body(result);
			} else {
				result.setStatus(200);
				result.setMessage("Success");
				result.setData(author);
				return ResponseEntity.ok(result);
			}
		} catch (Exception e) {
			@SuppressWarnings("rawtypes")
			StatusMessageDto error = new StatusMessageDto(500, e.getMessage(), null);
			return ResponseEntity.status(500).body(error);
		}
	}

//	@SuppressWarnings("unchecked")
//	@PutMapping("/author/{authorCode}")
//	public ResponseEntity<?> put(@PathVariable String authorCode, @RequestBody AuthorDto dto){
//		try {
//
//			AuthorEntity author = service.put(authorCode, dto);
//
//			if (dto.getAuthorCode() == null) {
//				result.setStatus(HttpStatus.BAD_REQUEST.value());
//				result.setMessage("Kode autor tidak boleh kosong");
//				result.setData(null);
//				return ResponseEntity.badRequest().body(result);
//			} else {
//				result.setStatus(200);
//				result.setMessage("Success");
//				result.setData(author);
//				return ResponseEntity.ok(result);
//			}
//		} catch (Exception e) {
//			@SuppressWarnings("rawtypes")
//			StatusMessageDto error = new StatusMessageDto(500, e.getMessage(), null);
//			return ResponseEntity.status(500).body(error);
//		}
//	}
	
	@PutMapping("/author/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody AuthorDto dto) {
		return ResponseEntity.ok(service.update(id, dto));
	}
	
	@DeleteMapping("/author/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return ResponseEntity.ok(service.delete(id));
	}
}