package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.FineDto;
import com.Faraday.Library.entity.FineEntity;

public interface FineService {
	List<FineEntity> getAll();
	FineEntity post(FineDto dto);
}
