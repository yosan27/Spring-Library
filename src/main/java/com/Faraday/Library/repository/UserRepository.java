package com.Faraday.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByEmail(String email);

	UserEntity findByUserCode(String userCode);

	UserEntity findByStatus(Integer status);

	// find all User active by id
	@Query(value = "select * from user_entity where status = 1 and id = ?", nativeQuery = true)
	List<UserEntity> findAllUserActiveById(Integer id);

	// find all User active by user code
	@Query(value = "select * from user_entity where status = 1 and user_code = ?", nativeQuery = true)
	List<UserEntity> findAllUserActiveByUserCode(String userCode);

	// find all User active by email
	@Query(value = "select * from user_entity where status = 1 and email = ?", nativeQuery = true)
	List<UserEntity> findAllUserActiveByEmail(String email);
	
	//get last user
	@Query(value = "select user_code from user_entity where role = ? order by id desc limit 1", nativeQuery = true)
	public String findLastUser(Integer role);

}