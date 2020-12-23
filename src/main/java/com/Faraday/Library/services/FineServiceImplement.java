package com.Faraday.Library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Faraday.Library.dto.FineDto;
import com.Faraday.Library.entity.FineEntity;
import com.Faraday.Library.repository.FineRepository;

@Service
@Transactional
public class FineServiceImplement implements FineService{

	@Autowired
	FineRepository fineRepository;
	
	@Override
	public List<FineEntity> getAll() {
		List<FineEntity> fineEntity = fineRepository.findAll();
		return fineEntity;
	}

	@Override
	public FineEntity post(FineDto dto) {
		FineEntity fineEntity = new FineEntity();
		fineEntity.setFineCode(dto.getFineCode());
		fineEntity.setFineType(dto.getFineType());
		fineEntity.setNominal(dto.getNominal());
		fineEntity.setValidFrom(dto.getValidFrom());
		fineEntity.setValidTo(dto.getValidTo());
		fineRepository.save(fineEntity);
		return fineEntity;
	}

}
