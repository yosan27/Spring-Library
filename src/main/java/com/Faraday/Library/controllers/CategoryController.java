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


import com.Faraday.Library.dto.CategoryDto;
import com.Faraday.Library.entity.CategoryEntity;
import com.Faraday.Library.services.CategoryServiceImplement;


@RestController
@RequestMapping("/api")
public class CategoryController {

	
	@Autowired
	private CategoryServiceImplement service;
	
	@GetMapping("/category")
	List<CategoryEntity> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/category")
	CategoryEntity post(@PathVariable CategoryDto dto) {
		return service.post(dto);
	}
	
	@DeleteMapping("/delete-category/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
		
		CategoryEntity categoryEntity = service.delete(id);
		return ResponseEntity.ok(categoryEntity);
	}
	
	@PutMapping("/update-category/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody CategoryDto dto){
		
		CategoryEntity categoryEntity = service.update(id, dto);
		return ResponseEntity.ok(categoryEntity);
		
	}
	
}
