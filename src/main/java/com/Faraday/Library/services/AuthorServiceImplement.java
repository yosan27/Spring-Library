package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.BookDetailsDto;
import com.Faraday.Library.entity.BookDetailsEntity;
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
	
	public List<AuthorEntity> getActiveId(){
		List<AuthorEntity> authorEntities = authorRepository.findActiveId();
		return authorEntities;
	}
	
	public AuthorEntity getById(Integer id){
		AuthorEntity authorEntity = authorRepository.findById(id).get();
		return authorEntity;
	}

//	@Override
//	public AuthorEntity post(AuthorDto dto) {
//		AuthorEntity authorEntity = new AuthorEntity();
//		authorEntity.setAuthorCode(dto.getAuthorCode());
//		authorEntity.setAuthorName(dto.getAuthorName());
//		authorRepository.save(authorEntity);
//		return authorEntity;
//	}

	@Override
	public AuthorEntity post(AuthorDto dto) {
		AuthorEntity author = new AuthorEntity();
		author.setAuthorCode("");
		author.setAuthorName(dto.getAuthorName());
		author.setStatus(1);
		authorRepository.save(author);

		String kodeAuthor = "";
		Integer authorId = author.getId();
		if(authorId.toString().length() == 1) kodeAuthor = "BA00" + authorId.toString();
		else if (authorId.toString().length() == 2) kodeAuthor = "BA0" + authorId.toString();
		else if (authorId.toString().length() == 3) kodeAuthor = "BA" + authorId.toString();
		author.setAuthorCode(kodeAuthor);
		authorRepository.save(author);
		return author;
	}

	@Override
	public AuthorEntity put(String authorCode, AuthorDto dto) {
		AuthorEntity author = authorRepository.findByAuthorCodeIgnoreCase(authorCode);

		if (author == null) {
			author = null;
			return author;
		}

		author.setAuthorCode(dto.getAuthorCode());
		author.setAuthorName(dto.getAuthorName());
		authorRepository.save(author);
		return author;
	}
	
	public AuthorEntity update(Integer id, AuthorDto dto) {
		AuthorEntity author = authorRepository.findById(id).get();
		author.setAuthorName(dto.getAuthorName());
		authorRepository.save(author);
		return author;
	}
	
	public AuthorEntity delete(Integer id) {
		AuthorEntity author = authorRepository.findById(id).get();
		author.setStatus(0);
		authorRepository.save(author);
		return author;
	}
}