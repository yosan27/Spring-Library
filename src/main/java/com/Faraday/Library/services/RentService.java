package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.RentDto;
import com.Faraday.Library.entity.RentEntity;

public interface RentService {
	List<RentEntity> getAll();
	RentEntity getById(Integer id);
	RentEntity checkStatus(Integer id);
	RentEntity getByRentCode(String rentCode);
	List<RentEntity> getByStatus(Integer status);
	List<RentEntity> getByUserCode(String userCode);
	List<RentEntity> getByUserCodeStatus(String userCode);
	RentEntity insert(RentDto dto);
	RentEntity updateStatus(Integer id, RentDto dto);
	RentEntity updateOnlyStatusByRentCode(String rentCode, RentDto dto);
	RentEntity updateStatusByRentCode(String rentCode, RentDto dto);
	RentEntity getByBookCode(String bookCode);
}
