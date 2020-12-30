package com.Faraday.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Faraday.Library.dto.PublisherDto;
import com.Faraday.Library.services.PublisherServiceImplement;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PublisherController {
	
	@Autowired
	private PublisherServiceImplement service;
	
	@GetMapping("/publisher")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/publisher/get-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.getById(id));
	}
	
	@PostMapping("/publisher")
	public ResponseEntity<?> insert(@RequestBody PublisherDto dto) {
		return ResponseEntity.ok(service.insert(dto));
	}
	
	@PutMapping("/publisher/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody PublisherDto dto) {
		return ResponseEntity.ok(service.update(id, dto));
	}
	
	@DeleteMapping("/publisher/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return ResponseEntity.ok(service.delete(id));
	}
}