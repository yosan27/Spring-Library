package com.Faraday.Library.services;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.List;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Faraday.Library.dto.UserDto;
import com.Faraday.Library.entity.UserEntity;
import com.Faraday.Library.repository.UserRepository;

@Service
@Transactional
public class UserServiceImplement implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<UserEntity> getAll() {
		// TODO Auto-generated method stub
		List<UserEntity> userEntities = userRepository.findAll();
		return userEntities;
	}
	
	@Override
	public UserEntity getAllUserActiveById(Integer id) {
		// TODO Auto-generated method stub
		UserEntity userEntities = userRepository.findAllUserActiveById(id);
		return userEntities;
	}
	
	@Override
	public UserEntity getALlUserById(Integer id) {
		// TODO Auto-generated method stub
		UserEntity userEntities = userRepository.findAllUserById(id);
		return userEntities;
	}

	
	@Override
	public UserEntity getAllUserActiveByUserCode(String userCode) {
		// TODO Auto-generated method stub
		UserEntity userEntities = userRepository.findAllUserActiveByUserCode(userCode);
		return userEntities;
	}

	@Override
	public List<UserEntity> getAllUserActiveByEmail(String email) {
		// TODO Auto-generated method stub
		List<UserEntity> userEntities = userRepository.findAllUserActiveByEmail(email);
		return userEntities;
	}

	@Override
	public UserEntity getAllUserByEmail(String email) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findByEmail(email);
		return userEntity;
	}

	@Override
	public UserEntity getAllUserByUserCode(String userCode) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findByUserCode(userCode);
		return userEntity;
	}
	
	@Override
	public UserEntity getAllUserByUserName(String userName) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findByUserName(userName);
		return userEntity;
	}


	@Override
	public UserEntity getAllUserByStatus(Integer status) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findByStatus(status);
		return userEntity;
	}

	@Override
	public UserEntity insertUser(UserDto dto) {
		// TODO Auto-generated method stub
		UserEntity userEntity = converToUserEntity(2, dto);
		userRepository.save(userEntity);
		return userEntity;
	}
	
	@Override
	public UserEntity insertAdmin(UserDto dto) {
		// TODO Auto-generated method stub
		UserEntity userEntity = converToUserEntity(1, dto);
		userRepository.save(userEntity);
		return userEntity;
	}

	@Override
	public UserEntity updateUser(Integer id, UserDto dto) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findById(id).get();
		userEntity.setProfilePict(userEntity.getUserCode()+"_profile_"+dto.getProfilePict());
		userEntity.setPhone(dto.getPhone());
		userEntity.setAddress(dto.getAddress());
		userRepository.save(userEntity);
		return userEntity;
	}
	
	@Override
	public UserEntity updateUserPassword(Integer id, UserDto dto) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findById(id).get();
		userEntity.setPassword(dto.getPassword());
		userRepository.save(userEntity);
		return userEntity;
	}


	@Override
	public UserEntity deleteUser(Integer id) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findById(id).get();
		userEntity.setStatus(0);
		userRepository.save(userEntity);
		return userEntity;
	}
	
	@Override
	public UserEntity updateUserBalance(Integer id, UserDto dto) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findById(id).get();
		userEntity.setBalance(dto.getBalance());
		userRepository.save(userEntity);
		return userEntity;
	}
	
	@Override
	public UserEntity updateUserSuspend(Integer id, UserDto dto) {
		// TODO Auto-generated method stub
		LocalDate today = LocalDate.now();
		UserEntity userEntity = userRepository.findById(id).get();
		Integer suspend = dto.getStatus();
		if(suspend == 1) {
			LocalDate oneweek = today.plusDays(7);
			Date date = Date.valueOf(oneweek);
			userEntity.setUnsuspendDate(date);
		} else if(suspend == 2) {
			LocalDate twoweek = today.plusDays(14);
			Date date = Date.valueOf(twoweek);
			userEntity.setUnsuspendDate(date);
		} else if(suspend == 3) {
			LocalDate thirdweek = today.plusDays(21);
			Date date = Date.valueOf(thirdweek);
			userEntity.setUnsuspendDate(date);
		} else if(suspend == 4) {
			LocalDate fourthweek = today.plusDays(28);
			Date date = Date.valueOf(fourthweek);
			userEntity.setUnsuspendDate(date);
		}
		userEntity.setStatus(2);
		userRepository.save(userEntity);
		return userEntity;
	}

	public UserEntity converToUserEntity(Integer role, UserDto dto) {
		List<UserEntity> userEntities = userRepository.findAll();
		
		String userCode = "";
		
		String code = "";
		
		if(role.equals(2)) {
			code = "UU";
		}else {
			code = "UA";
		}
		
		if(userEntities.size() < 1) {
			userCode="001";
		}else {
			for(UserEntity e : userEntities) {
				if(e.getUserCode().substring(0, 2).equals(code)) {					
					String getLastUser = userRepository.findLastUser(role);
					String numberCode = getLastUser.substring(2);
					String n1 = numberCode.substring(0, 1);
					String n2 = numberCode.substring(1, 2);
					String n3 = numberCode.substring(2, 3);
					Integer x = Integer.parseInt(n1);
					Integer y = Integer.parseInt(n2);
					Integer z = Integer.parseInt(n3);
					if(z.equals(9)) {
						z = 0;
						y += 1;
						if(y.equals(9)) {
							y = 0;
							x += 1;
							userCode = x.toString()+y.toString()+z.toString();
							break;
						}else {
							y+=1;
							userCode = x.toString()+y.toString()+z.toString();
							break;
						}
					}else {
						z += 1;
						userCode = x.toString()+y.toString()+z.toString();
						break;
					}
				}else {
					userCode="001";
				}
			}
		}
		
		UserEntity userEntity = new UserEntity();
		
			
		userEntity.setUserCode(code+""+userCode);
		userEntity.setUserName(dto.getUserName());
		userEntity.setEmail(dto.getEmail());
		userEntity.setPassword(dto.getPassword());
		userEntity.setFullName(dto.getFullName());
		userEntity.setPhone(dto.getPhone());
		userEntity.setAddress(dto.getAddress());
		userEntity.setProfilePict(code+""+userCode+"_profile_"+dto.getProfilePict());
		userEntity.setBalance(0);
		userEntity.setRole(role);
		userEntity.setStatus(1);
		return userEntity;
	}

	
	

}
