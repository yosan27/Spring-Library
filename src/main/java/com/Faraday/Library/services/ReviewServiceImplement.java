package com.Faraday.Library.services;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Faraday.Library.dto.ReviewDto;
import com.Faraday.Library.entity.BookDetailsEntity;
import com.Faraday.Library.entity.BookEntity;
import com.Faraday.Library.entity.ReviewEntity;
import com.Faraday.Library.entity.UserEntity;
import com.Faraday.Library.repository.BookDetailsRepository;
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
	@Autowired
	private BookDetailsRepository bookDetailRepository;

	@Override
	public List<ReviewEntity> getAll() {
		// TODO Auto-generated method stub
		return reviewRepository.findId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReviewEntity> getByBookDetailCode(String bookDetailCode) {
		// TODO Auto-generated method stub
		return reviewRepository.findByBookDetailCode(bookDetailCode);
	}

	@Override
	public ReviewEntity post(ReviewDto dto) {
		// TODO Auto-generated method stub
		LocalDate today = LocalDate.now();
		Date date = Date.valueOf(today);
		
		ReviewEntity reviewEntity = new ReviewEntity();
		UserEntity userEntity = userRepository.findByUserCode(dto.getUserCode());
		BookDetailsEntity bookDetailsEntity = bookDetailRepository.findByBookDetailCode(dto.getBookDetailCode());

		reviewEntity.setUserEntity(userEntity);
		reviewEntity.setBookDetailsEntity(bookDetailsEntity);
		reviewEntity.setRate(dto.getRate());
		reviewEntity.setReview(dto.getReview());
		reviewEntity.setDate(date);
		reviewEntity.setStatus(1);
		reviewRepository.save(reviewEntity);
		return reviewEntity;
	}
	
	
	
}
