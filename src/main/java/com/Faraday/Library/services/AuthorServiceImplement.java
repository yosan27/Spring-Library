package com.Faraday.Library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Faraday.Library.repository.AuthorRepository;
import com.Faraday.Library.dto.AuthorDto;
import com.Faraday.Library.entity.AuthorEntity;

@Service
@Transactional
public class AuthorServiceImplement implements AuthorService{
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public List<AuthorEntity> getAll(){
		List<AuthorEntity> authorEntity = authorRepository.findAll();
		return authorEntity;
	}
	
	@Override
	public AuthorEntity post(AuthorDto dto) {
		AuthorEntity authorEntity = new AuthorEntity();
		authorEntity.setAuthorCode(dto.getAuthorCode());
		authorEntity.setAuthorName(dto.getAuthorName());
		authorRepository.save(authorEntity);
		return authorEntity;
	}
}
