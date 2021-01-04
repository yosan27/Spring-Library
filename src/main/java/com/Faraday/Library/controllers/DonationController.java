package com.Faraday.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Faraday.Library.dto.DonationDto;
import com.Faraday.Library.services.DonationServiceImpl;

@RestController
@RequestMapping("/api")
public class DonationController {
	@Autowired
	private DonationServiceImpl donation;
	
	@GetMapping("/donation")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(donation.getAll());
	}
	
	@GetMapping("/donation/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return ResponseEntity.ok(donation.getById(id));
	}
	
	@GetMapping("/donation/status/{status}")
	public ResponseEntity<?> getByStatus(@PathVariable Integer status){
		return ResponseEntity.ok(donation.getByStatus(status));
	}
	
	@PostMapping("/donation")
	public ResponseEntity<?> insert(@RequestBody DonationDto dto){
		return ResponseEntity.ok(donation.insert(dto));
	}

	@PutMapping("/donation/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody DonationDto dto){
		return ResponseEntity.ok(donation.updateStatus(id, dto));
	}
}
