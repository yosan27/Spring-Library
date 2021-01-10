package com.Faraday.Library.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Faraday.Library.dto.FineDto;
import com.Faraday.Library.entity.FineEntity;
//import com.Faraday.Library.exception.APIException;
import com.Faraday.Library.exception.ResourceNotFoundException;
import com.Faraday.Library.services.FineServiceImplement;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class FineController {
	
	@Autowired
	FineServiceImplement service;
	
	@GetMapping("/fine")
	List<FineEntity> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/fine/code/{code}")
	FineEntity getByCode(@PathVariable String code){
		return service.getByCode(code);
	}
	
	@GetMapping("/fine/id/{id}")
	FineEntity getByCode(@PathVariable Integer id) throws ResourceNotFoundException {
		try {
			return service.getById(id);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Data With ID : " + id + " Not Found!");
		}
	}
	
	@GetMapping("/fine/active")
	List<FineEntity> getActive() {
		LocalDate localDate = LocalDate.now();
		Date date = Date.valueOf(localDate);
		return service.getActive(date);
	}
	
	@PostMapping("/fine")
	FineEntity post(@RequestBody FineDto dto) {
		return service.post(dto);
	}
	
	@PutMapping("/fine/{id}")
	FineEntity post(@RequestBody FineDto dto, @PathVariable Integer id) {
		return service.update(dto, id);
	}
	
	@DeleteMapping("/fine/{id}")
	FineEntity post(@PathVariable Integer id) {
		return service.delete(id);
	}
}
