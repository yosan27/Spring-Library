package com.Faraday.Library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Faraday.Library.dto.RentDto;
import com.Faraday.Library.entity.BookEntity;
import com.Faraday.Library.entity.RentEntity;
import com.Faraday.Library.entity.UserEntity;
import com.Faraday.Library.repository.BookRepository;
import com.Faraday.Library.repository.RentRepository;
import com.Faraday.Library.repository.UserRepository;

@Service
@Transactional
public class RentServiceImplement implements RentService {

	@Autowired
	private RentRepository rentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<RentEntity> getAll() {
		List<RentEntity> rentEntities = rentRepository.findAll();
		return rentEntities;
	}

	@Override
	public RentEntity getById(Integer id) {
		RentEntity rentEntity = rentRepository.findById(id).get();
		return rentEntity;
	}
	
	@Override
	public List<RentEntity> getByRentCode(String rentCode) {
		List<RentEntity> rentEntities = rentRepository.findByRentCode(rentCode);
		return rentEntities;
	}
	
	@Override
	public List<RentEntity> getByStatus(Integer status) {
		List<RentEntity> rentEntities = rentRepository.findByStatus(status);
		return rentEntities;
	}

	@Override
	public RentEntity insert(RentDto dto) {
		Integer id = 0;
		String rentCode = "";
		
		RentEntity rentEntity = new RentEntity();
		UserEntity userEntity = userRepository.findByUserCode(dto.getUserCode());
		BookEntity bookEntity = bookRepository.findByBookCodeIgnoreCase(dto.getBookCode());
		
		rentEntity.setRentCode("");
		rentEntity.setDateBorrow(dto.getDateBorrow());
		rentEntity.setDueDate(dto.getDueDate());
		rentEntity.setDateReturn(dto.getDateReturn());
		rentEntity.setStatus(1);
		rentEntity.setUserEntity(userEntity);
		rentEntity.setBookEntity(bookEntity);
		rentRepository.save(rentEntity);
		
		id = rentEntity.getId();
		if(id.toString().length() == 1) rentCode = "R00" + id.toString();
		else if (id.toString().length() == 2) rentCode = "R0" + id.toString();
		else if (id.toString().length() == 3) rentCode = "R" + id.toString();
		
		rentEntity.setRentCode(rentCode);
		rentRepository.save(rentEntity);
		return rentEntity;
	}

	@Override
	public RentEntity updateStatus(Integer id, RentDto dto) {
		RentEntity rentEntity = rentRepository.findById(id).get();
		rentEntity.setStatus(dto.getStatus()); // 1=PENDING, 2=BORROW, 3=OVERDUE, 4=WAITING PAYMENT, 5=RETURN
		rentRepository.save(rentEntity);
		return rentEntity;
	}
}
