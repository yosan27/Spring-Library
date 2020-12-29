package com.Faraday.Library.services;

import java.sql.Date;
import java.util.List;

import com.Faraday.Library.dto.FineDto;
import com.Faraday.Library.entity.FineEntity;

public interface FineService {
	List<FineEntity> getAll();
	List<FineEntity> getActive(Date date);
	FineEntity getByCode(String code);
	FineEntity getById(Integer id);
	FineEntity post(FineDto dto);
	FineEntity update(FineDto dto, Integer id);
	FineEntity delete(Integer id);
}
