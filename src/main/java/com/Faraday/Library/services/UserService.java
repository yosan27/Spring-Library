package com.Faraday.Library.services;

import java.util.List;
import java.sql.Date;

import com.Faraday.Library.dto.UserDto;
import com.Faraday.Library.entity.UserEntity;

public interface UserService {
	
	public List<UserEntity> getAll();
	public UserEntity getAllUserActiveById(Integer id);
	public UserEntity getALlUserById(Integer id);
	public UserEntity getAllUserActiveByUserCode(String userCode);
	public UserEntity getAllUserActiveByUserName(String userName);
	public UserEntity getAllUserActiveByEmail(String email);
	public UserEntity getAllUserByEmail(String email);
	public UserEntity getAllUserByUserCode(String userCode);
	public UserEntity getAllUserByUserName(String userName);
	public UserEntity getAllUserByStatus(Integer status);
	public UserEntity insertUser(UserDto dto);
	public UserEntity insertAdmin(UserDto dto);
	public UserEntity updateUser(Integer id, UserDto dto);
	public UserEntity updateUserPassword(Integer id, UserDto dto);
	public UserEntity deleteUser(Integer id);
	public UserEntity updateUserBalance(Integer id, UserDto dto);
	public UserEntity updateUserSuspend(Integer id, UserDto dto);
	public UserEntity updateUserUnsuspend(Integer id, UserDto dto);

}
