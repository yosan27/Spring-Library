package com.Faraday.Library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Faraday.Library.dto.PublisherDto;
import com.Faraday.Library.entity.PublisherEntity;
import com.Faraday.Library.repository.PublisherRepository;

@Service
@Transactional
public class PublisherServiceImplement implements PublisherService {
	
	@Autowired
	PublisherRepository publisherRepository;

	@Override
	public List<PublisherEntity> getAll() {
		List<PublisherEntity> publisherEntities = publisherRepository.findAll();
		return publisherEntities;
	}
	
	@Override
	public PublisherEntity getById(Integer id) {
		PublisherEntity publisherEntity = publisherRepository.findById(id).get();
		return publisherEntity;
	}

	@Override
	public PublisherEntity insert(PublisherDto dto) {
		Integer id = 0;
		String publisherCode = "";
		
		PublisherEntity publisherEntity = new PublisherEntity();
		publisherEntity.setPublisherCode("");
		publisherEntity.setPublisherName(dto.getPublisherName());
		publisherEntity.setAddress(dto.getAddress());
		publisherRepository.save(publisherEntity);
		
		id = publisherEntity.getId();
		if(id.toString().length() == 1) publisherCode = "BP00" + id.toString();
		else if (id.toString().length() == 2) publisherCode = "BP0" + id.toString();
		else if (id.toString().length() == 3) publisherCode = "BP" + id.toString();
		
		publisherEntity.setPublisherCode(publisherCode);
		publisherRepository.save(publisherEntity);
		return publisherEntity;
	}
	
	@Override
	public PublisherEntity update(Integer id, PublisherDto dto) {
		PublisherEntity publisherEntity = publisherRepository.findById(id).get();
		publisherEntity.setPublisherCode(dto.getPublisherCode());
		publisherEntity.setPublisherName(dto.getPublisherName());
		publisherEntity.setAddress(dto.getAddress());
		publisherRepository.save(publisherEntity);
		return publisherEntity;
	}
	
	@Override
	public PublisherEntity delete(Integer id) {
		PublisherEntity publisherEntity = publisherRepository.findById(id).get();
		publisherRepository.delete(publisherEntity);
		return publisherEntity;
	}
}