package com.Faraday.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer>{
	
	
	List<CartEntity> findByUserEntityUserCode(String userCode);
	List<CartEntity> findByBookEntityBookCode(String bookCode);
}
