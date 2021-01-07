package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.TransactionDto;
import com.Faraday.Library.entity.TransactionEntity;

public interface TransactionService {
	List<TransactionEntity> getAll();
	TransactionEntity getById(Integer id);
	List<TransactionEntity> getByStatus(Integer status);
	List<TransactionEntity> getByUserCode(String userCode);
	TransactionEntity getByCode(String code);
	TransactionEntity post(TransactionDto dto);
	TransactionEntity update(TransactionDto dto, Integer id);
}
