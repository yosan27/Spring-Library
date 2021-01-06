package com.Faraday.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Faraday.Library.dto.RentDto;
import com.Faraday.Library.dto.StatusMessageDto;
import com.Faraday.Library.entity.RentEntity;
import com.Faraday.Library.services.RentServiceImplement;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class RentController {
	
	@Autowired
	private RentServiceImplement service;
	
	@GetMapping("/rent")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/rent/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.getById(id));
	}
	
	@GetMapping("/rent/code/{rentCode}")
	public ResponseEntity<?> getByRentCode(@PathVariable String rentCode) {
		return ResponseEntity.ok(service.getByRentCode(rentCode));
	}
	
	@GetMapping("/rent/status/{status}")
	public ResponseEntity<?> getByStatus(@PathVariable Integer status) {
		return ResponseEntity.ok(service.getByStatus(status));
	}
	
	@GetMapping("/rent/user-code/{userCode}")
	public ResponseEntity<?> getByUserCode(@PathVariable String userCode) {
		return ResponseEntity.ok(service.getByUserCode(userCode));
	}
	
	@PostMapping("/rent")
	public ResponseEntity<?> insert(@RequestBody RentDto dto) {
		return ResponseEntity.ok(service.insert(dto));
	}
	
	@PutMapping("/rent/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody RentDto dto) {
		return ResponseEntity.ok(service.updateStatus(id, dto));
	}
	
	@GetMapping("/rent/bookcode/{bookCode}")
	public ResponseEntity<?> getByBookCode(@PathVariable String bookCode) {
		StatusMessageDto<RentEntity> result = new StatusMessageDto<>();
		RentEntity rentEntity = service.getByBookCode(bookCode);
		result.setStatus(HttpStatus.OK.value());
		if(rentEntity != null) {
			result.setMessage("Success!");
			result.setData(rentEntity);
		}else {
			result.setMessage("Data Null");
			result.setData(null);
		}
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/rent/code/{rentCode}")
	public ResponseEntity<?> updateStatusByRentCode(@PathVariable String rentCode, @RequestBody RentDto dto) {
		return ResponseEntity.ok(service.updateStatusByRentCode(rentCode, dto));
	}
	
	@PutMapping("/rent/status/{id}")
	public ResponseEntity<?> updateStatusTakeBook(@PathVariable Integer id) {
		return ResponseEntity.ok(service.updateStatusTakeBook(id));
	}
}
