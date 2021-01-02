package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.AuthorDto;
import com.Faraday.Library.entity.AuthorEntity;

public interface AuthorService {
	List<AuthorEntity> getAll();
	AuthorEntity post(AuthorDto dto);
	AuthorEntity put(String authorCode, AuthorDto dto);
}
