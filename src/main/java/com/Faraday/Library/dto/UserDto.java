package com.Faraday.Library.dto;


import java.util.Date;

import lombok.Data;

@Data
public class UserDto {
	private Integer id;
	private String userCode;
	private String email;
	private String password;
	private String fullName;
	private String profilePict;
	private String phone;
	private Integer balance;
	private Integer role;
	private Date createdAt;
	private Integer status;
	
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserDto(Integer id, String userCode, String email, String password, String fullName, String profilePict,
			String phone, Integer balance, Integer role, Date createdAt, Integer status) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.profilePict = profilePict;
		this.phone = phone;
		this.balance = balance;
		this.role = role;
		this.createdAt = createdAt;
		this.status = status;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUserCode() {
		return userCode;
	}


	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getProfilePict() {
		return profilePict;
	}


	public void setProfilePict(String profilePict) {
		this.profilePict = profilePict;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Integer getBalance() {
		return balance;
	}


	public void setBalance(Integer balance) {
		this.balance = balance;
	}


	public Integer getRole() {
		return role;
	}


	public void setRole(Integer role) {
		this.role = role;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}
}
