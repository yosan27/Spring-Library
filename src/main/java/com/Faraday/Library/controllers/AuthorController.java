package com.Faraday.Library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Faraday.Library.services.AuthorServiceImplement;
import com.Faraday.Library.dto.AuthorDto;
import com.Faraday.Library.entity.AuthorEntity;


@RestController
@RequestMapping("/api")
public class AuthorController {
	
	@Autowired
	AuthorServiceImplement service;
	
	@GetMapping("/author")
	List<AuthorEntity> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/author")
	AuthorEntity post(@PathVariable AuthorDto dto) {
		return service.post(dto);
	}
}
