package com.Faraday.Library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Faraday.Library.dto.WishlistDto;
import com.Faraday.Library.entity.WishlistEntity;
import com.Faraday.Library.services.WishlistServiceImplement;

@RestController
@RequestMapping("/api")
public class WishlistController {
	
	@Autowired
	private WishlistServiceImplement service;
	
	@GetMapping("/wishlist-by-user/{userCode}")
	public ResponseEntity<?> getWishlistByUserCode(@PathVariable String userCode){
		List<WishlistEntity> wishEntities = service.getWishlistByUserCode(userCode);
		return ResponseEntity.ok(wishEntities);
	}
	
	@GetMapping("/wishlist-by-book/{bookCode}")
	public ResponseEntity<?> getWishlistByBookCode(@PathVariable String bookCode){
		List<WishlistEntity> wishEntities = service.getWishlistByBookCode(bookCode);
		return ResponseEntity.ok(wishEntities);
	}
	
	@GetMapping("/wishlist-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		WishlistEntity wishEntities = service.getWishlistById(id);
		return ResponseEntity.ok(wishEntities);
	}
	
	@PostMapping("/wishlist")
	public ResponseEntity<?> insertwishlist(@RequestBody WishlistDto dto){
		if(dto.getUserCode().equals("")) {
			return ResponseEntity.badRequest().body("tidak boleh kosong");
		}else {
			WishlistEntity wishEntity = service.insertWish(dto);
			return ResponseEntity.ok(wishEntity);
		}
	}
	
	@PutMapping("/wishlist/{id}")
	public ResponseEntity<?> updatewishlist(@PathVariable Integer id, @RequestBody WishlistDto dto){
		if(dto.getUserCode().equals("")) {
			return ResponseEntity.badRequest().body("tidak boleh kosong");
		}else {
			WishlistEntity wishEntity = service.updateWish(id, dto);
			return ResponseEntity.ok(wishEntity);
		}
	}
	
	@DeleteMapping("/wishlist/{id}")
	public ResponseEntity<?> deletewishlist(@PathVariable Integer id){
		WishlistEntity wishEntity = service.deleteWish(id);
		return ResponseEntity.ok(wishEntity);
	}
}
