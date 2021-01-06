package com.Faraday.Library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Faraday.Library.dto.TransactionDetailDto;
import com.Faraday.Library.entity.FineEntity;
import com.Faraday.Library.entity.RentEntity;
import com.Faraday.Library.entity.TransactionDetailEntity;
import com.Faraday.Library.entity.TransactionEntity;
import com.Faraday.Library.entity.UserEntity;
import com.Faraday.Library.repository.FineRepository;
import com.Faraday.Library.repository.RentRepository;
import com.Faraday.Library.repository.TransactionDetailRepository;
import com.Faraday.Library.repository.TransactionRepository;
import com.Faraday.Library.repository.UserRepository;

@Service
@Transactional
public class TransactionDetailServiceImplement implements TransactionDetailService{

	@Autowired
	TransactionDetailRepository repo;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	FineRepository fineRepository;
	
	@Autowired
	RentRepository rentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<TransactionDetailEntity> getAll() {
		List<TransactionDetailEntity> transactionDetailEntity = repo.findAll();
		return transactionDetailEntity;
	}

	@Override
	public TransactionDetailEntity getById(Integer id) {
		TransactionDetailEntity transactionDetailEntity = repo.findById(id).get();
		return transactionDetailEntity;
	}

	@Override
	public List<TransactionDetailEntity> getByTransactionCode(String code) {
		List<TransactionDetailEntity> transactionDetailEntity = repo.findByTransactionCode(code);
		return transactionDetailEntity;
	}

	@Override
	public TransactionDetailEntity getByCode(String code) {
		TransactionDetailEntity transactionDetailEntity = repo.findByCode(code);
		return transactionDetailEntity;
	}

	@Override
	public List<TransactionDetailEntity> getByFineCode(String code) {
		List<TransactionDetailEntity> transactionDetailEntity = repo.findByFineCode(code);
		return transactionDetailEntity;
	}

	@Override
	public TransactionDetailEntity post(TransactionDetailDto dto) {
		TransactionDetailEntity transactionDetailEntity = new TransactionDetailEntity();
		TransactionEntity transactionEntity = transactionRepository.findByCode(dto.getTransactionCode());
		FineEntity fineEntity = fineRepository.findByCode(dto.getFineCode());
		RentEntity rentEntity = rentRepository.findByRentCode(dto.getRentCode());
		UserEntity userEntity = userRepository.findByUserCode(dto.getUserCode());
		transactionDetailEntity.setDetailCode(dto.getDetailCode());
		transactionDetailEntity.setDescription(dto.getDescription());
		transactionDetailEntity.setDebet(dto.getDebet());
		transactionDetailEntity.setKredit(dto.getKredit());
		transactionDetailEntity.setTransactionEntity(transactionEntity);
		transactionDetailEntity.setFineEntity(fineEntity);
		transactionDetailEntity.setRentEntity(rentEntity);
		transactionDetailEntity.setUserEntity(userEntity);
		repo.save(transactionDetailEntity);
		return transactionDetailEntity;
	}

	@Override
	public TransactionDetailEntity update(TransactionDetailDto dto, Integer id) {
		TransactionDetailEntity transactionDetailEntity = repo.findById(id).get();
		FineEntity fineEntity = fineRepository.findByCode(dto.getFineCode());
		transactionDetailEntity.setDescription(dto.getDescription());
		transactionDetailEntity.setDebet(dto.getDebet());
		transactionDetailEntity.setKredit(dto.getKredit());
		transactionDetailEntity.setFineEntity(fineEntity);
		repo.save(transactionDetailEntity);
		return transactionDetailEntity;
	}

	@Override
	public List<TransactionDetailEntity> getByRentCode(String code) {
		List<TransactionDetailEntity> transactionDetailEntity = repo.findByRentCode(code);
		return transactionDetailEntity;
	}

	@Override
	public List<TransactionDetailEntity> getByUserCode(String code) {
		List<TransactionDetailEntity> transactionDetailEntity = repo.findByUserCode(code);
		return transactionDetailEntity;
	}

	@Override
	public List<TransactionDetailEntity> getByBill(String userCode) {
		List<TransactionDetailEntity> transactionDetailEntity = repo.findByBill(userCode);
		return transactionDetailEntity;
	}

}
