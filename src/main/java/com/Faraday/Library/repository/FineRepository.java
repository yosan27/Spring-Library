package com.Faraday.Library.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.FineEntity;

@Repository
public interface FineRepository extends JpaRepository<FineEntity, Integer>{
	@Query(value = "select * from fine_entity where fine_code = ?", nativeQuery = true)
	FineEntity findByCode(String code);
	
	@Query(value = "select * from fine_entity where valid_to >= ?", nativeQuery = true)
	List<FineEntity> findActive(Date date);
}
