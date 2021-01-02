package com.Faraday.Library.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Faraday.Library.dto.TransactionDto;
import com.Faraday.Library.entity.TransactionEntity;
import com.Faraday.Library.entity.UserEntity;
import com.Faraday.Library.repository.TransactionRepository;
import com.Faraday.Library.repository.UserRepository;


@Service
@Transactional
public class TransactionServiceImplement implements TransactionService{

	@Autowired
	TransactionRepository repo;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<TransactionEntity> getAll() {
		List<TransactionEntity> transactionEntity = repo.findAll();
		return transactionEntity;
	}

	@Override
	public List<TransactionEntity> getByDate(Date date) {
		List<TransactionEntity> transactionEntity = repo.findByDate(date);
		return transactionEntity;
	}

	@Override
	public List<TransactionEntity> getByStatus(Integer status) {
		List<TransactionEntity> transactionEntity = repo.findByStatus(status);
		return transactionEntity;
	}

	@Override
	public List<TransactionEntity> getByUserCode(String userCode) {
		List<TransactionEntity> transactionEntity = repo.findByUserCode(userCode);
		return transactionEntity;
	}

	@Override
	public TransactionEntity getByCode(String code) {
		TransactionEntity transactionEntity = repo.findByCode(code);
		return transactionEntity;
	}

	@Override
	public TransactionEntity post(TransactionDto dto) {
		TransactionEntity transactionEntity = new TransactionEntity();
		UserEntity userEntity = userRepository.findByUserCode(dto.getUserCode());
		transactionEntity.setTransactionCode(dto.getTransactionCode());
		
		LocalDate date = LocalDate.now();
		Date inputDate = Date.valueOf(date);
		transactionEntity.setDate(inputDate);
		
		transactionEntity.setNominal(dto.getNominal());
		transactionEntity.setPaymentMethod(dto.getPaymentMethod());
		transactionEntity.setPaymentStatus(dto.getPaymentStatus());
		transactionEntity.setUserEntity(userEntity);
		
		repo.save(transactionEntity);
		return transactionEntity;
	}

	@Override
	public TransactionEntity update(TransactionDto dto, Integer id) {
		TransactionEntity transactionEntity = repo.findById(id).get();
		UserEntity userEntity = userRepository.findByUserCode(dto.getUserCode());
		transactionEntity.setTransactionCode(dto.getTransactionCode());
		transactionEntity.setNominal(dto.getNominal());
		transactionEntity.setPaymentMethod(dto.getPaymentMethod());
		transactionEntity.setPaymentStatus(dto.getPaymentStatus());
		transactionEntity.setUserEntity(userEntity);
		
		repo.save(transactionEntity);
		return transactionEntity;
	}

	@Override
	public TransactionEntity delete(Integer id) {
		TransactionEntity transactionEntity = repo.findById(id).get();
		return transactionEntity;
	}

	@Override
	public TransactionEntity getById(Integer id) {
		TransactionEntity transactionEntity = repo.findById(id).get();
		return transactionEntity;
	}

	@Override
	public TransactionEntity getByRentCode(String rentCode) {
		TransactionEntity transactionEntity = repo.findByRentCode(rentCode);
		return transactionEntity;
	}

}
