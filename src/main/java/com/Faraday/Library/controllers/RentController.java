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
import com.Faraday.Library.exception.APIException;
import com.Faraday.Library.exception.ResourceNotFoundException;
import com.Faraday.Library.services.RentServiceImplement;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class RentController {
	
	@Autowired
	private RentServiceImplement service;
	
	@GetMapping("/rent")
	public ResponseEntity<?> getAll() throws APIException {
		try {
			return ResponseEntity.ok(service.getAll());
		} catch (Exception e) {
			throw new APIException ("Sorry! Cannot Connect To Database Server");
		}
	}
	
	@GetMapping("/rent/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) throws ResourceNotFoundException {
		try {
			return ResponseEntity.ok(service.getById(id));
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resource With ID : " + id + " Not Found!");
		}
	}
	
	@GetMapping("/rent/code/{rentCode}")
	public ResponseEntity<?> getByRentCode(@PathVariable String rentCode) throws ResourceNotFoundException {
		try {
			return ResponseEntity.ok(service.getByRentCode(rentCode));
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resource With Rent Code : " + rentCode + " Not Found!");
		}
	}
	
	@GetMapping("/rent/status/{status}")
	public ResponseEntity<?> getByStatus(@PathVariable Integer status) throws ResourceNotFoundException {
		try {
			return ResponseEntity.ok(service.getByStatus(status));
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resource With Status : " + status + " Not Found!");
		}
		
	}
	
	@GetMapping("/rent/usercode/{userCode}")
	public ResponseEntity<?> getByUserCode(@PathVariable String userCode) throws ResourceNotFoundException {
		try {
			return ResponseEntity.ok(service.getByUserCode(userCode));
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resource With User Code : " + userCode + " Not Found!");
		}
		
	}
	
	@GetMapping("/rent/userstatus/{userCode}")
	public ResponseEntity<?> getByUserCodeStatus(@PathVariable String userCode) throws ResourceNotFoundException {
		try {
			return ResponseEntity.ok(service.getByUserCodeStatus(userCode));
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resource With User Code : " + userCode + " Not Found!");
		}
	}
	
	@PostMapping("/rent")
	public ResponseEntity<?> insert(@RequestBody RentDto dto) throws APIException {
		try {
			return ResponseEntity.ok(service.insert(dto));
		} catch (Exception e) {
			throw new APIException ("Sorry! Cannot Connect To Database Server");
		}
	}
	
	@PutMapping("/rent/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody RentDto dto) throws ResourceNotFoundException {
		try {
			return ResponseEntity.ok(service.updateStatus(id, dto));
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resource With ID : " + id + " Not Found!");
		}
	}
	
	@PutMapping("/rent/code/{rentCode}")
	public ResponseEntity<?> updateStatusByRentCode(@PathVariable String rentCode, @RequestBody RentDto dto) throws ResourceNotFoundException{
		try {
			return ResponseEntity.ok(service.updateStatusByRentCode(rentCode, dto));
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With Rent Code : " + rentCode + " Not Found!");
		}
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
}
