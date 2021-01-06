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
	
	@GetMapping("/transaction-detail/id/{id}")
	TransactionDetailEntity getById(@PathVariable Integer id){
		return service.getById(id);
	}
	
	@GetMapping("/transaction-detail/code/{code}")
	TransactionDetailEntity getByCode(@PathVariable String code){
		return service.getByCode(code);
	}
	
	@GetMapping("/transaction-detail/transaction/{code}")
	List<TransactionDetailEntity> getByTransactionCode(@PathVariable String code){
		return service.getByTransactionCode(code);
	}
	
	@GetMapping("/transaction-detail/user/{code}")
	List<TransactionDetailEntity> getByUserCode(@PathVariable String code){
		return service.getByUserCode(code);
	}
	
	@GetMapping("/transaction-detail/bill/{userCode}")
	List<TransactionDetailEntity> getByBill(@PathVariable String userCode){
		return service.getByBill(userCode);
	}
	
	@GetMapping("/transaction-detail/rent/{code}")
	List<TransactionDetailEntity> getByRentCode(@PathVariable String code){
		return service.getByRentCode(code);
	}
	
	@GetMapping("/transaction-detail/fine/{code}")
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
	
	@PutMapping("/transaction-detail/code/{code}")
	TransactionDetailEntity updateByCode(@RequestBody TransactionDetailDto dto, @PathVariable String code){
		return service.updateByCode(dto, code);
	}
}
