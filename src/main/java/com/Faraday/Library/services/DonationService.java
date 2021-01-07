package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.DonationDto;
import com.Faraday.Library.entity.DonationEntity;

public interface DonationService {
	List<DonationEntity> getAll();
	List<DonationEntity> getByStatus(Integer id);
	DonationEntity getById(Integer id);
	DonationEntity insert(DonationDto dto);
	DonationEntity updateStatus(Integer id, DonationDto dto );
	DonationEntity delete(Integer id);
}
