package com.Faraday.Library.repository;

import java.util.List;

import com.Faraday.Library.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.PublisherEntity;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity, Integer> {
	@Query(value = "select * from publisher_entity where status = 1", nativeQuery = true)
	List<PublisherEntity> findActiveId();

	@Query(value = "select publisher_name from publisher_entity where publisher_name = ?", nativeQuery = true)
	String findPublisherName(String publisherName);
	
	PublisherEntity findByPublisherCode(String publisherCode);

	//get last code
	@Query(value = "select publisher_code from publisher_entity order by id desc limit 1", nativeQuery = true)
	String findLastCode();

	@Query(value = "select publisher_code from publisher_entity where=?", nativeQuery = true)
	PublisherEntity findLastCodePublisher(String publisherCode);
}