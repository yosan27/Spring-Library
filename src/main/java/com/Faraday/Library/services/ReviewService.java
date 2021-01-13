package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.ReviewDto;
import com.Faraday.Library.entity.ReviewEntity;

public interface ReviewService {
	List<ReviewEntity> getAll();
	List<ReviewEntity> getByBookDetailCode(String bookDetailCode);
	ReviewEntity post(ReviewDto dto);
	List<ReviewEntity> getRate(String bookCode);
	List<ReviewEntity> getRateByBookDetail(String code);
}
