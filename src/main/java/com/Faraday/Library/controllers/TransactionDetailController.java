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

import com.Faraday.Library.dto.TransactionDetailDto;
import com.Faraday.Library.entity.TransactionDetailEntity;
import com.Faraday.Library.exception.APIException;
import com.Faraday.Library.exception.ResourceNotFoundException;
import com.Faraday.Library.services.TransactionDetailService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionDetailController {
	
	@Autowired
	TransactionDetailService service;
	
	@GetMapping("/transaction-detail")
	List<TransactionDetailEntity> getAll() throws APIException{
		try {
			return service.getAll();
		}catch(Exception e) {
			throw new APIException ("Sorry! Cannot Connect To Database Server");
		}
	}
	
	@GetMapping("/transaction-detail/id/{id}")
	TransactionDetailEntity getById(@PathVariable Integer id) throws ResourceNotFoundException {
		try {
			return service.getById(id);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With ID : " + id + " Not Found!");
		}
	}
	
	@GetMapping("/transaction-detail/code/{code}")
	TransactionDetailEntity getByCode(@PathVariable String code) throws ResourceNotFoundException {
		try {
			return service.getByCode(code);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With Transaction Detail Code : " + code + " Not Found!");
		}
	}
	
	@GetMapping("/transaction-detail/transaction/{code}")
	List<TransactionDetailEntity> getByTransactionCode(@PathVariable String code) throws ResourceNotFoundException {
		try {
			return service.getByTransactionCode(code);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With Transaction Code : " + code + " Not Found!");
		}
	}
	
	@GetMapping("/transaction-detail/user/{code}")
	List<TransactionDetailEntity> getByUserCode(@PathVariable String code) throws ResourceNotFoundException {
		try {
			return service.getByUserCode(code);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With User Code : " + code + " Not Found!");
		}
	}
	
	@GetMapping("/transaction-detail/bill/{userCode}")
	List<TransactionDetailEntity> getByBill(@PathVariable String userCode) throws ResourceNotFoundException {
		try {
			return service.getByBill(userCode);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With User Code : " + userCode + " Not Found!");
		}
	}
	
	@GetMapping("/transaction-detail/rent/{code}")
	List<TransactionDetailEntity> getByRentCode(@PathVariable String code) throws ResourceNotFoundException {
		try {
			return service.getByRentCode(code);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With Rent Code : " + code + " Not Found!");
		}
	}
	
	@GetMapping("/transaction-detail/fine/{code}")
	List<TransactionDetailEntity> getByFineCode(@PathVariable String code) throws ResourceNotFoundException {
		try {
			return service.getByFineCode(code);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With Fine Code : " + code + " Not Found!");
		}
	}
	
	@PostMapping("/transaction-detail")
	TransactionDetailEntity post(@RequestBody TransactionDetailDto dto) throws APIException{
		try {
			return service.post(dto);
		}catch(Exception e) {
			throw new APIException ("Sorry! Cannot Connect To Database Server");
		}
	}
	
	@PutMapping("/transaction-detail/{id}")
	TransactionDetailEntity update(@RequestBody TransactionDetailDto dto, @PathVariable Integer id) throws ResourceNotFoundException  {
		try {
			return service.update(dto, id);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With ID : " + id + " Not Found!");
		}
	}
	
	@PutMapping("/transaction-detail/code/{code}")
	TransactionDetailEntity updateByCode(@RequestBody TransactionDetailDto dto, @PathVariable String code) throws ResourceNotFoundException {
		try {
			return service.updateByCode(dto, code);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Resource With Transaction Detail Code : " + code + " Not Found!");
		}
	}
}
