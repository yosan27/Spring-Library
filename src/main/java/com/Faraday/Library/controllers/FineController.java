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
import com.Faraday.Library.exception.APIException;
//import com.Faraday.Library.exception.APIException;
import com.Faraday.Library.exception.ResourceNotFoundException;
import com.Faraday.Library.services.FineServiceImplement;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FineController {
	
	@Autowired
	FineServiceImplement service;
	
	@GetMapping("/fine")
	List<FineEntity> getAll() throws APIException {
		try {
			return service.getAll();
		}catch(Exception e) {
			throw new APIException ("Sorry! Cannot Connect To Database Server");
		}
	}
	
	@GetMapping("/fine/code/{code}")
	FineEntity getByCode(@PathVariable String code) throws ResourceNotFoundException {
		try {
			return service.getByCode(code);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With Fine Code : " + code + " Not Found!");
		}
	}
	
	@GetMapping("/fine/id/{id}")
	FineEntity getById(@PathVariable Integer id) throws ResourceNotFoundException {
		try {
			return service.getById(id);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With ID : " + id + " Not Found!");
		}
	}
	
	@GetMapping("/fine/active")
	List<FineEntity> getActive() throws APIException {
		try {
			LocalDate localDate = LocalDate.now();
			Date date = Date.valueOf(localDate);
			return service.getActive(date);
		}catch(Exception e) {
			throw new APIException ("Sorry! Cannot Connect To Database Server");
		}
	}
	
	@PostMapping("/fine")
	FineEntity post(@RequestBody FineDto dto) throws APIException {
		try {
			return service.post(dto);
		}catch(Exception e) {
			throw new APIException ("Sorry! Cannot Connect To Database Server");
		}
	}
	
	@PutMapping("/fine/{id}")
	FineEntity post(@RequestBody FineDto dto, @PathVariable Integer id) throws ResourceNotFoundException {
		try {
			return service.update(dto, id);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With ID : " + id + " Not Found!");
		}
	}
	
	@DeleteMapping("/fine/{id}")
	FineEntity post(@PathVariable Integer id) throws ResourceNotFoundException {
		try {
			return service.delete(id);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With ID : " + id + " Not Found!");
		}
	}
}
