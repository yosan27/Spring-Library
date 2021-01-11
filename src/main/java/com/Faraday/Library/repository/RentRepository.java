package com.Faraday.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.RentEntity;

@Repository
public interface RentRepository extends JpaRepository<RentEntity, Integer> {
	RentEntity findByRentCode(String rentCode);
	
	List<RentEntity> findByStatus(Integer status);
	
	List<RentEntity> findByUserEntityUserCode(String userCode);
	
	@Query(value = "select * from rent_entity where user_code = ? and status not in (5, 6)", nativeQuery = true)
	List<RentEntity> findByUserCodeStatus(String userCode);
	
	//get last book status rent
	@Query(value = "select * from rent_entity where book_code = ? order by id desc limit 1", nativeQuery = true)
	RentEntity findStatusBookLastRent(String bookCode);
}
