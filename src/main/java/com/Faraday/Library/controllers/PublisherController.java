package com.Faraday.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Faraday.Library.dto.PublisherDto;
import com.Faraday.Library.services.PublisherServiceImplement;

@RestController
@RequestMapping("/api")
public class PublisherController {
	
	@Autowired
	private PublisherServiceImplement service;
	
	@GetMapping("/publisher")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/publisher/active")
	public ResponseEntity<?> getActiveId() {
		return ResponseEntity.ok(service.getActiveId());
	}
	
	@GetMapping("/publisher/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.getById(id));
	}
	
	@GetMapping("/publisher/code/{publisherCode}")
	public ResponseEntity<?> getByCode(@PathVariable String publisherCode) {
		return ResponseEntity.ok(service.getByPublisherCode(publisherCode));
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