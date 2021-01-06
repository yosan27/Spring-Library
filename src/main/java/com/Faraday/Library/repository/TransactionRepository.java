package com.Faraday.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.TransactionEntity;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer>{
	@Query(value = "select * from transaction_entity where transaction_code = ?", nativeQuery = true)
	TransactionEntity findByCode(String code);
	
	@Query(value = "select * from transaction_entity where user_code = ?", nativeQuery = true)
	List<TransactionEntity> findByUserCode(String userCode);
	
	@Query(value = "select * from transaction_entity where payment_status = ?", nativeQuery = true)
	List<TransactionEntity> findByStatus(Integer status);
}
