package com.Faraday.Library.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Faraday.Library.dto.ReviewDto;
import com.Faraday.Library.entity.BookEntity;
import com.Faraday.Library.entity.ReviewEntity;
import com.Faraday.Library.entity.UserEntity;
import com.Faraday.Library.repository.BookRepository;
import com.Faraday.Library.repository.ReviewRepository;
import com.Faraday.Library.repository.UserRepository;

@Service
@Transactional
public class ReviewServiceImplement implements ReviewService {
	
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<ReviewEntity> getAll() {
		// TODO Auto-generated method stub
		return reviewRepository.findId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReviewEntity> getByBookCode(String bookCode) {
		// TODO Auto-generated method stub
		return reviewRepository.findByBookCode(bookCode);
	}

	@Override
	public ReviewEntity post(ReviewDto dto) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
		String formatted = date.format(formatter);
		
		ReviewEntity reviewEntity = new ReviewEntity();
		UserEntity userEntity = userRepository.findByUserCode(dto.getUser_code());
		BookEntity bookEntity = bookRepository.findByBookCodeIgnoreCase(dto.getBook_code());

		reviewEntity.setUserEntity(userEntity);
		reviewEntity.setBookEntity(bookEntity);
		reviewEntity.setRate(dto.getRate());
		reviewEntity.setReview(dto.getReview());
		reviewEntity.setDate(formatted);
		reviewEntity.setStatus(1);
		reviewRepository.save(reviewEntity);
		return reviewEntity;
	}
	
	
	
}
