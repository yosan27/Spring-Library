package com.Faraday.Library.controllers;

import com.Faraday.Library.dto.StatusMessageDto;
import com.Faraday.Library.exception.APIException;
import com.Faraday.Library.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Faraday.Library.services.AuthorServiceImplement;
import com.Faraday.Library.dto.AuthorDto;
import com.Faraday.Library.entity.AuthorEntity;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AuthorController {

	@Autowired
	AuthorServiceImplement service;

	@SuppressWarnings("rawtypes")
	private StatusMessageDto result = new StatusMessageDto();

	@GetMapping("/author")
	public ResponseEntity<?> getAll() throws APIException {
		try {
			return ResponseEntity.ok(service.getAll());
		} catch (Exception e) {
			throw new APIException("Sorry! Cannot Connect To Database Server");
		}
	}
	
	@GetMapping("/author/active")
	public ResponseEntity<?> getActiveId() throws APIException {
		try {
			return ResponseEntity.ok(service.getActiveId());
		} catch (Exception e) {
			throw new APIException("Sorry! Cannot Connect To Database Server");
		}
	}
	
	@GetMapping("/author/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) throws ResourceNotFoundException {
		try {
			return ResponseEntity.ok(service.getById(id));
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resource With ID : \" + id + \" Not Found!");
		}
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/author")
	public ResponseEntity<?> post(@RequestBody AuthorDto dto){
		try {
			if (dto.getAuthorName() == null) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
				result.setMessage("Author Name Is Blank!");
				result.setData(null);
				return ResponseEntity.badRequest().body(result);
			} else {
				AuthorEntity author = service.post(dto);
				
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

	@SuppressWarnings("unchecked")
	@PutMapping("/author/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody AuthorDto dto){
		try {
			if (dto.getAuthorName().equals("") || dto.getAuthorName().substring(0, 1).equals(" ")) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
				result.setMessage("Author Name Is Blank!");
				result.setData(null);
				return ResponseEntity.badRequest().body(result);
			} else {
				AuthorEntity author = service.update(id, dto);
				
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
	
	@DeleteMapping("/author/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) throws ResourceNotFoundException {
		try {
			return ResponseEntity.ok(service.delete(id));
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resource With ID : " + id + " Not Found!");
		}
	}
}