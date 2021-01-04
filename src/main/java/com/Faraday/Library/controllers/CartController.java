package com.Faraday.Library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Faraday.Library.dto.CartDto;
import com.Faraday.Library.entity.CartEntity;
import com.Faraday.Library.services.CartServiceImplement;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
	
	@Autowired
	private CartServiceImplement service;

	@GetMapping("/cart-by-user/{userCode}")
	public ResponseEntity<?> getByUserCode(@PathVariable String userCode){
		List<CartEntity> cartEntities = service.getByUserCode(userCode);
		return ResponseEntity.ok(cartEntities);
	}
	
	@GetMapping("/cart-by-book/{bookCode}")
	public ResponseEntity<?> getByBookCode(@PathVariable String bookCode){
		List<CartEntity> cartEntities = service.getByBookCode(bookCode);
		return ResponseEntity.ok(cartEntities);
	}
	
	@GetMapping("/cart-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		CartEntity cartEntities = service.getById(id);
		return ResponseEntity.ok(cartEntities);
	}
	
	@PostMapping("/cart")
	public ResponseEntity<?> insertCart(@RequestBody CartDto dto){
		if(dto.getUserCode().equals("")) {
			return ResponseEntity.badRequest().body("tidak boleh kosong");
		}else {
			CartEntity cartEntity = service.insertCart(dto);
			return ResponseEntity.ok(cartEntity);
		}
	}
	
	@PutMapping("/cart/{id}")
	public ResponseEntity<?> updateCart(@PathVariable Integer id, @RequestBody CartDto dto){
		if(dto.getUserCode().equals("")) {
			return ResponseEntity.badRequest().body("tidak boleh kosong");
		}else {
			CartEntity cartEntity = service.updateCart(id, dto);
			return ResponseEntity.ok(cartEntity);
		}
	}
	
	@DeleteMapping("/cart/{id}")
	public ResponseEntity<?> deleteCart(@PathVariable Integer id){
		CartEntity cartEntity = service.deleteCart(id);
		return ResponseEntity.ok(cartEntity);
	}
}
