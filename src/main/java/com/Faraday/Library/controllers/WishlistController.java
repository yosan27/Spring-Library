package com.Faraday.Library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.Faraday.Library.dto.StatusMessageDto;
import com.Faraday.Library.dto.WishlistDto;
import com.Faraday.Library.entity.RentEntity;
import com.Faraday.Library.entity.WishlistEntity;
import com.Faraday.Library.services.WishlistServiceImplement;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class WishlistController {
	
	@Autowired
	private WishlistServiceImplement service;
	
	@SuppressWarnings("rawtypes")
    private StatusMessageDto result = new StatusMessageDto();
	
	@SuppressWarnings("unchecked")
	@GetMapping("/wishlist/usercode/{userCode}")
	public ResponseEntity<?> getWishlistByUserCode(@PathVariable String userCode){
		List<WishlistEntity> wishEntities = service.getWishlistByUserCode(userCode);
		if (wishEntities.size() == 0) {
            result.setStatus(HttpStatus.BAD_REQUEST.value());
            result.setMessage("Data not found");
            result.setData(null);
            return ResponseEntity.badRequest().body(result);
        } else {
            result.setStatus(200);
            result.setMessage("Success");
            result.setData(wishEntities);
            return ResponseEntity.ok(result);
        }
	}
	
	@GetMapping("/wishlist/bookdetailscode/{bookDetailsCode}")
	public ResponseEntity<?> getByBookDetailsCode(@PathVariable String bookDetailsCode){
		List<WishlistEntity> wishEntities = service.getByBookDetailsCode(bookDetailsCode);
		return ResponseEntity.ok(wishEntities);
	}
	
	@GetMapping("/wishlist/id/{id}")
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
