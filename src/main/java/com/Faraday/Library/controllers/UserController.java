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

import com.Faraday.Library.dto.UserDto;
import com.Faraday.Library.entity.UserEntity;
import com.Faraday.Library.services.UserServiceImplement;

import lombok.Data;

@Data
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserServiceImplement service;
	
	
	@GetMapping("/user")
	public ResponseEntity<?> getAll(){
		List<UserEntity> userEntities = service.getAll();
		return ResponseEntity.ok(userEntities);
	}
	
	@GetMapping("/user-by-id/{id}")
	public ResponseEntity<?> getAllUserById(@PathVariable Integer id){
		UserEntity userEntities = service.getAllUserActiveById(id);
		return ResponseEntity.ok(userEntities);
	}
	
	@GetMapping("/user-by-code/{code}")
	public ResponseEntity<?> getAllUserByCode(@PathVariable String code){
		UserEntity userEntities = service.getAllUserActiveByUserCode(code);
		return ResponseEntity.ok(userEntities);
	}
	
	@GetMapping("/user-by-email/{email}")
	public ResponseEntity<?> getAllUserByEmail(@PathVariable String email){
		List<UserEntity> userEntities = service.getAllUserActiveByEmail(email);
		return ResponseEntity.ok(userEntities);
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> insertUser(@RequestBody UserDto dto){
		if(dto.getFullName().equals("") || dto.getEmail().equals("") || dto.getPassword().equals("")) {
			return ResponseEntity.badRequest().body("tidak boleh kosong");				
		}else {
			List<UserEntity> cekEmail = service.getAllUserActiveByEmail(dto.getEmail());
			if(cekEmail.size() > 0) {
				return ResponseEntity.badRequest().body("Email Sudah Terdaftar");	
			}else {
				UserEntity userEntity = service.insertUser(dto);
				return ResponseEntity.ok(userEntity);				
			}
		}
	}
	
	@PostMapping("/user-admin")
	public ResponseEntity<?> insertAdmin(@RequestBody UserDto dto){
		if(dto.getFullName().equals("") || dto.getEmail().equals("") || dto.getPassword().equals("")) {
			return ResponseEntity.badRequest().body("tidak boleh kosong");				
		}else {
			List<UserEntity> cekEmail = service.getAllUserActiveByEmail(dto.getEmail());
			if(cekEmail.size() > 0) {
				return ResponseEntity.badRequest().body("Email Sudah Terdaftar");	
			}else {
				UserEntity userEntity = service.insertAdmin(dto);
				return ResponseEntity.ok(userEntity);				
			}
		}
	}
	
	@PutMapping("/user-profile/{id}")
	public ResponseEntity<?> updateUserProfile(@PathVariable Integer id, @RequestBody UserDto dto){
		if(dto.getFullName().equals("")) {
			return ResponseEntity.badRequest().body("nama tidak boleh kosong");			
		}else {
			UserEntity userEntity = service.updateUser(id, dto);
			return ResponseEntity.ok(userEntity);
		}
	}
	
	@PutMapping("/user-password/{id}")
	public ResponseEntity<?> updateUserPassword(@PathVariable Integer id, @RequestBody UserDto dto){
		if(dto.getPassword().equals("")) {
			return ResponseEntity.badRequest().body("password tidak boleh kosong");			
		}else {
			UserEntity userEntity = service.updateUserPassword(id, dto);
			return ResponseEntity.ok(userEntity);
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id){
		List<UserEntity> userEntities = service.getAll();
		Integer status = 0;
		for(UserEntity e : userEntities) {
			if(e.getId().equals(id)) {
				UserEntity userEntity = service.deleteUser(id);
				status = HttpStatus.OK.value();
				break;
			}else {
				status = HttpStatus.BAD_REQUEST.value();
			}
		}
		
		if(status == HttpStatus.OK.value()) {
			return ResponseEntity.ok("berhasil terhapus");
		}else {
			return ResponseEntity.badRequest().body("gagal menemukan akun");
		}
	}
	
	@PutMapping("/user-balance/{id}")
	public ResponseEntity<?> updateUserBalance(@PathVariable Integer id, @RequestBody UserDto dto){
		if(dto.getBalance().equals("")) {
			return ResponseEntity.badRequest().body("password tidak boleh kosong");			
		}else {
			UserEntity userEntity = service.updateUserBalance(id, dto);
			return ResponseEntity.ok(userEntity);
		}
	}
	
	
}
