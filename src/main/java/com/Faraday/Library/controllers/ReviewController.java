package com.Faraday.Library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Faraday.Library.dto.ReviewDto;
import com.Faraday.Library.dto.StatusMessageDto;
import com.Faraday.Library.entity.ReviewEntity;
import com.Faraday.Library.exception.ResourceNotFoundException;
import com.Faraday.Library.security.jwt.JwtUtils;
import com.Faraday.Library.services.ReviewServiceImplement;

import lombok.Data;

@Data
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ReviewController {
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@SuppressWarnings("rawtypes")
	private StatusMessageDto result = new StatusMessageDto();

	@Autowired
	private ReviewServiceImplement service;
	
	@GetMapping("/review")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/review/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id ) {
		return ResponseEntity.ok(service.getById(id));
	}
	
	@GetMapping("/reviewLook/{bookDetailCode}")
	public ResponseEntity<?> getByBookDetailCode(@PathVariable String bookDetailCode) {
		return ResponseEntity.ok(service.getByBookDetailCode(bookDetailCode));
	}
	
	@GetMapping("/review/rate/{bookCode}")
	public ResponseEntity<?> getRateByBookCode(@PathVariable String bookCode) {
		return ResponseEntity.ok(service.getRate(bookCode));
	}
	
	@GetMapping("/review/rate-by/{bookDetailCode}")
	public List<ReviewEntity> getRateByBookDetailCode(@PathVariable String bookDetailCode) {
		return service.getRateByBookDetail(bookDetailCode);
	}
	
	
	@PostMapping("/review")
	public ResponseEntity<?> post(@RequestBody ReviewDto dto){
		return ResponseEntity.ok(service.post(dto));
	}
	
	@PutMapping("/review/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ReviewDto dto){
		return ResponseEntity.ok(service.update(id, dto));
	}
	
	@DeleteMapping("/review/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) throws ResourceNotFoundException {
		return ResponseEntity.ok(service.delete(id));
	}
	
	
}
