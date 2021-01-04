package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.TransactionDetailDto;
import com.Faraday.Library.entity.TransactionDetailEntity;

public interface TransactionDetailService {
	List<TransactionDetailEntity> getAll();
	List<TransactionDetailEntity> getByRentCode(String code);
	TransactionDetailEntity getById(Integer id);
	List<TransactionDetailEntity> getByTransactionCode(String code);
	TransactionDetailEntity getByCode(String code);
	List<TransactionDetailEntity> getByFineCode(String code);
	TransactionDetailEntity post(TransactionDetailDto dto);
	TransactionDetailEntity update(TransactionDetailDto dto, Integer id);
}
