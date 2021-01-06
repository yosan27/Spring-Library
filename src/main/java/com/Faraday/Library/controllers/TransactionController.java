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
import com.Faraday.Library.services.TransactionServiceImplement;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {

	@Autowired
	TransactionServiceImplement service;
	
	@GetMapping("/transaction")
	List<TransactionEntity> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/transaction/id/{id}")
	TransactionEntity getById(@PathVariable Integer id){
		return service.getById(id);
	}
	
	@GetMapping("/transaction/status/{status}")
	List<TransactionEntity> getByStatus(@PathVariable Integer status){
		return service.getByStatus(status);
	}
	
	@GetMapping("/transaction/code/{code}")
	TransactionEntity getByCode(@PathVariable String code){
		return service.getByCode(code);
	}
	
	@GetMapping("/transaction/user/{userCode}")
	List<TransactionEntity> getByUserCode(@PathVariable String userCode){
		return service.getByUserCode(userCode);
	}
	
	@PostMapping("/transaction")
	TransactionEntity post(@RequestBody TransactionDto dto) {
		return service.post(dto);
	}
	
	@PutMapping("/transaction/{id}")
	TransactionEntity update(@RequestBody TransactionDto dto, @PathVariable Integer id) {
		return service.update(dto, id);
	}
}
