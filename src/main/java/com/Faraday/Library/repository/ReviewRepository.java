package com.Faraday.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.ReviewEntity;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
	
	@Query(value = "select * from review_entity where status = 1", nativeQuery = true)
	List<ReviewEntity> findId();
	
	@Query(value = "select review_entity.id, review_entity.user_code, review_entity.book_detail_code, review_entity.rate, review_entity.review, review_entity.date, review_entity.status, user_entity.full_name FROM review_entity INNER JOIN user_entity ON review_entity.user_code = user_entity.user_code WHERE review_entity.book_detail_code = ?", nativeQuery = true)
	List<ReviewEntity> findByBookDetailCode(String bookDetailCode);
}
