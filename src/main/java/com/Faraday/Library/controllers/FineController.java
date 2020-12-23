package com.Faraday.Library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Faraday.Library.dto.FineDto;
import com.Faraday.Library.entity.FineEntity;
import com.Faraday.Library.services.FineServiceImplement;

@RestController
@RequestMapping("/api")
public class FineController {
	
	@Autowired
	FineServiceImplement service;
	
	@GetMapping("/fine")
	List<FineEntity> getAll() {
		return service.getAll();
	}
	
	@PostMapping("/fine")
	FineEntity post(@PathVariable FineDto dto) {
		return service.post(dto);
	}
}
