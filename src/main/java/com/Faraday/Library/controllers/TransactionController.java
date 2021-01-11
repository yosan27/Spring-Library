package com.Faraday.Library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Faraday.Library.dto.TransactionDto;
import com.Faraday.Library.entity.TransactionEntity;
import com.Faraday.Library.exception.APIException;
import com.Faraday.Library.exception.ResourceNotFoundException;
import com.Faraday.Library.services.TransactionServiceImplement;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TransactionController {

	@Autowired
	TransactionServiceImplement service;
	
	@GetMapping("/transaction")
	List<TransactionEntity> getAll() throws APIException {
		try {
			return service.getAll();
		}catch(Exception e) {
			throw new APIException ("Sorry! Cannot Connect To Database Server");
		}
	}
	
	@GetMapping("/transaction/id/{id}")
	TransactionEntity getById(@PathVariable Integer id) throws ResourceNotFoundException {
		try {
			return service.getById(id);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With ID : " + id + " Not Found!");
		}
	}
	
	@GetMapping("/transaction/status/{status}")
	List<TransactionEntity> getByStatus(@PathVariable Integer status) throws ResourceNotFoundException {
		try {
			return service.getByStatus(status);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With Status : " + status + " Not Found!");
		}
	}
	
	@GetMapping("/transaction/code/{code}")
	TransactionEntity getByCode(@PathVariable String code) throws ResourceNotFoundException {
		try {
			return service.getByCode(code);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With Transaction Code : " + code + " Not Found!");
		}
	}
	
	@GetMapping("/transaction/user/{userCode}")
	List<TransactionEntity> getByUserCode(@PathVariable String userCode) throws ResourceNotFoundException {
		try {
			return service.getByUserCode(userCode);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With User Code : " + userCode + " Not Found!");
		}
	}
	
	@PostMapping("/transaction")
	TransactionEntity post(@RequestBody TransactionDto dto) throws APIException {
		try {
			return service.post(dto);
		}catch(Exception e) {
			throw new APIException ("Sorry! Cannot Connect To Database Server");
		}
	}
	
	@PutMapping("/transaction/{id}")
	TransactionEntity update(@RequestBody TransactionDto dto, @PathVariable Integer id) throws ResourceNotFoundException {
		try {
			return service.update(dto, id);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With ID : " + id + " Not Found!");
		}
	}
}
