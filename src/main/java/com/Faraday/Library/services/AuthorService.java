package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.AuthorDto;
import com.Faraday.Library.entity.AuthorEntity;

public interface AuthorService {
	List<AuthorEntity> getAll();
	List<AuthorEntity> getActiveId();
	AuthorEntity getById(Integer id);
	AuthorEntity post(AuthorDto dto);
	AuthorEntity update(Integer id, AuthorDto dto);
	AuthorEntity delete(Integer id);
}
