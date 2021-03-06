package com.Faraday.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.TransactionDetailEntity;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetailEntity, Integer> {
	@Query(value = "select * from transaction_detail_entity where detail_code = ?", nativeQuery = true)
	TransactionDetailEntity findByCode(String code);
	
	@Query(value = "select * from transaction_detail_entity where transaction_code = ?", nativeQuery = true)
	List<TransactionDetailEntity> findByTransactionCode(String code);
	
	@Query(value = "select * from transaction_detail_entity where user_code = ?", nativeQuery = true)
	List<TransactionDetailEntity> findByUserCode(String code);
	
	@Query(value = "select * from transaction_detail_entity where fine_code = ?", nativeQuery = true)
	List<TransactionDetailEntity> findByFineCode(String code);
	
	@Query(value = "select * from transaction_detail_entity where rent_code = ?", nativeQuery = true)
	List<TransactionDetailEntity> findByRentCode(String code);
	
	@Query(value = "select * from transaction_detail_entity where user_code = ? and kredit != 0", nativeQuery = true)
	List<TransactionDetailEntity> findByBill(String userCode);
	
}
