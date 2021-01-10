package com.Faraday.Library.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "user_entity")
public class UserEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "username", length=255, nullable=false, unique=true)
	private String userName;
	
	@Column(name = "user_code", length=255, nullable=false, unique=true)
	private String userCode;
	
	@Column(name = "email", length=255, nullable=false, unique=true)
	private String email;
	
	@Column(name = "password", length=255, nullable=false)
	private String password;
	
	@Column(name = "full_name", length=255, nullable=false)
	private String fullName;
	
	@Column(name = "profile_pict", length=255, nullable=false)
	private String profilePict;
	
	@Column(name = "phone", length=255, nullable=false)
	private String phone;
	
	@Column(name = "address", length = 255, nullable = false)
	private String address;
	
	@Column(name = "balance", length=11, nullable=false)
	private Integer balance;
	
	@Column(name = "role", length=11, nullable=false)
	private Integer role;
	
	@Basic(optional = false)
	@Column(name = "created_at",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "unsuspend_date")
	private Date unsuspendDate;
	
	@Column(name = "status", length=11, nullable=false)
	private Integer status;

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
	
	public Date getUnsuspendDate() {
		return unsuspendDate;
	}

	public void setUnsuspendDate(Date unsuspendDate) {
		this.unsuspendDate = unsuspendDate;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
