package com.Faraday.Library.controllers;

import java.util.List;

import com.Faraday.Library.dto.AuthorDto;
import com.Faraday.Library.dto.StatusMessageDto;
import com.Faraday.Library.entity.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.Faraday.Library.dto.CategoryDto;
import com.Faraday.Library.entity.CategoryEntity;
import com.Faraday.Library.services.CategoryServiceImplement;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CategoryController {

	
	@Autowired
	private CategoryServiceImplement service;

	@SuppressWarnings("rawtypes")
	private StatusMessageDto result = new StatusMessageDto();
	
	@GetMapping("/category")
	List<CategoryEntity> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/category/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return ResponseEntity.ok(service.getById(id));
	}
	
//	@PostMapping("/category")
//	CategoryEntity post(@PathVariable CategoryDto dto) {
//		return service.post(dto);
//	}

	@SuppressWarnings("unchecked")
	@PostMapping("/category")
	public ResponseEntity<?> post(@RequestBody CategoryDto dto){
		try {

			CategoryEntity category = service.post(dto);

			if (dto.getCategoryName() == null) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
				result.setMessage("Nama kategori tidak boleh kosong");
				result.setData(null);
				return ResponseEntity.badRequest().body(result);
			} else {
				result.setStatus(200);
				result.setMessage("Success");
				result.setData(category);
				return ResponseEntity.ok(result);
			}
		} catch (Exception e) {
			@SuppressWarnings("rawtypes")
			StatusMessageDto error = new StatusMessageDto(500, e.getMessage(), null);
			return ResponseEntity.status(500).body(error);
		}
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
