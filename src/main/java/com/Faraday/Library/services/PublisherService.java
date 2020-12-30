package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.PublisherDto;
import com.Faraday.Library.entity.PublisherEntity;

public interface PublisherService {
	List<PublisherEntity> getAll();
	List<PublisherEntity> getActiveId();
	PublisherEntity getById(Integer id);
	PublisherEntity getByPublisherCode(String publisherCode);
	PublisherEntity insert(PublisherDto dto);
	PublisherEntity update(Integer id, PublisherDto dto);
	PublisherEntity delete(Integer id);
}