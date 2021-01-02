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
import com.Faraday.Library.services.TransactionDetailService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionDetailController {
	
	@Autowired
	TransactionDetailService service;
	
	@GetMapping("/transaction-detail")
	List<TransactionDetailEntity> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/transaction-detail/get-by-id/{id}")
	TransactionDetailEntity getById(@PathVariable Integer id){
		return service.getById(id);
	}
	
	@GetMapping("/transaction-detail/get-by-code/{code}")
	TransactionDetailEntity getByCode(@PathVariable String code){
		return service.getByCode(code);
	}
	
	@GetMapping("/transaction-detail/get-by-transaction-code/{code}")
	List<TransactionDetailEntity> getByTransactionCode(@PathVariable String code){
		return service.getByTransactionCode(code);
	}
	
	@GetMapping("/transaction-detail/get-by-fine-code/{code}")
	List<TransactionDetailEntity> getByFineCode(@PathVariable String code){
		return service.getByFineCode(code);
	}
	
	@PostMapping("/transaction-detail")
	TransactionDetailEntity post(@RequestBody TransactionDetailDto dto){
		return service.post(dto);
	}
	
	@PutMapping("/transaction-detail/{id}")
	TransactionDetailEntity update(@RequestBody TransactionDetailDto dto, @PathVariable Integer id){
		return service.update(dto, id);
	}
}
