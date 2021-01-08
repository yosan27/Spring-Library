package com.Faraday.Library.services;

import java.sql.Date;
import java.time.LocalDate;
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
		
		for (RentEntity rentEntity : rentEntities) {
			checkStatus(rentEntity.getId());
		}
		
		return rentEntities;
	}

	@Override
	public RentEntity getById(Integer id) {
		RentEntity rentEntity = rentRepository.findById(id).get();
		return rentEntity;
	}
	
	public RentEntity checkStatus(Integer id) {
		RentEntity rentEntity = getById(id);
		LocalDate today = LocalDate.now();
		LocalDate due = rentEntity.getDueDate().toLocalDate();
		
		if(rentEntity.getStatus() == 1 && today.isAfter(due)) {
			rentEntity.setDateReturn(Date.valueOf(due));
			rentEntity.setStatus(6); // 1=PENDING, 2=BORROW, 3=OVERDUE, 4=WAITING PAYMENT, 5=RETURN, 6=CANCEL
			rentRepository.save(rentEntity);
		}
		
		if(rentEntity.getStatus() == 2 && today.isAfter(due)) {
			rentEntity.setStatus(3); // 1=PENDING, 2=BORROW, 3=OVERDUE, 4=WAITING PAYMENT, 5=RETURN, 6=CANCEL
			rentRepository.save(rentEntity);
		}
		
		return rentEntity;
	}
	
	@Override
	public RentEntity getByRentCode(String rentCode) {
		RentEntity rentEntities = rentRepository.findByRentCode(rentCode);
		return rentEntities;
	}
	
	@Override
	public List<RentEntity> getByStatus(Integer status) {
		List<RentEntity> rentEntities = rentRepository.findByStatus(status);
		return rentEntities;
	}
	
	public List<RentEntity> getByUserCode(String userCode) {
		List<RentEntity> rentEntities = rentRepository.findByUserCode(userCode);
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
		rentEntity.setStatus(dto.getStatus()); // 1=PENDING, 2=BORROW, 3=OVERDUE, 4=WAITING PAYMENT, 5=RETURN, 6=CANCEL
		rentRepository.save(rentEntity);
		return rentEntity;
	}

	@Override
	public RentEntity updateStatusByRentCode(String rentCode, RentDto dto) {
		RentEntity rentEntity = rentRepository.findByRentCode(rentCode);
		rentEntity.setDateReturn(dto.getDateReturn());
		rentEntity.setStatus(dto.getStatus()); // 1=PENDING, 2=BORROW, 3=OVERDUE, 4=WAITING PAYMENT, 5=RETURN, 6=CANCEL
		rentRepository.save(rentEntity);
		return rentEntity;
	}

	@Override
	public RentEntity getByBookCode(String bookCode) {
		// TODO Auto-generated method stub
		RentEntity rentEntity = rentRepository.findStatusBookLastRent(bookCode);
		return rentEntity;
	}
	
	public RentEntity updateStatusTakeBook(Integer id) {
		RentEntity rentEntity = rentRepository.findById(id).get();
		rentEntity.setStatus(2); // 1=PENDING, 2=BORROW, 3=OVERDUE, 4=WAITING PAYMENT, 5=RETURN, 6=CANCEL
		rentRepository.save(rentEntity);
		return rentEntity;
	}
}
