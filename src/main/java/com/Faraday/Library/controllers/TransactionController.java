package com.Faraday.Library.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class TransactionController {

	@Autowired
	TransactionServiceImplement service;
	
	@GetMapping("/transaction")
	List<TransactionEntity> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/transaction/get-by-id/{id}")
	List<TransactionEntity> getById(@PathVariable Integer id){
		return service.getAll();
	}
	
	@GetMapping("/transaction/get-by-rent-code/{rentCode}")
	TransactionEntity getByRentCode(@PathVariable String rentCode){
		return service.getByRentCode(rentCode);
	}
	
	@GetMapping("/transaction/get-by-date")
	List<TransactionEntity> getByDate(@PathVariable String date){
		Date inputDate = Date.valueOf(date);
		return service.getByDate(inputDate);
	}
	
	@GetMapping("/transaction/get-by-status/{status}")
	List<TransactionEntity> getByStatus(@PathVariable Integer status){
		return service.getByStatus(status);
	}
	
	@GetMapping("/transaction/get-by-code/{code}")
	TransactionEntity getByCode(@PathVariable String code){
		return service.getByCode(code);
	}
	
	@GetMapping("/transaction/get-by-user-code/{userCode}")
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
	
	@DeleteMapping("/transaction/{id}")
	TransactionEntity delete(@PathVariable Integer id) {
		return service.delete(id);
	}
}
