package com.Faraday.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Faraday.Library.dto.ReviewDto;
import com.Faraday.Library.services.ReviewServiceImplement;

@RestController
@RequestMapping("/api")
public class ReviewController {

	@Autowired
	private ReviewServiceImplement service;
	
	@GetMapping("/review")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@PostMapping("/review")
	public ResponseEntity<?> post(@RequestBody ReviewDto dto){
		return ResponseEntity.ok(service.post(dto));
	}
	
	
	
}