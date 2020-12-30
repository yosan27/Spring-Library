package com.Faraday.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.RentEntity;

@Repository
public interface RentRepository extends JpaRepository<RentEntity, Integer> {
	List<RentEntity> findByRentCode(String rentCode);
	
	List<RentEntity> findByStatus(Integer status);
}
