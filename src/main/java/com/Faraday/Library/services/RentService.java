package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.RentDto;
import com.Faraday.Library.entity.RentEntity;

public interface RentService {
	List<RentEntity> getAll();
	RentEntity getById(Integer id);
	List<RentEntity> getByRentCode(String rentCode);
	List<RentEntity> getByStatus(Integer status);
	RentEntity insert(RentDto dto);
	RentEntity updateStatus(Integer id, RentDto dto);
}