package com.Faraday.Library.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "user_entity")
public class UserEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
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
	
	@Column(name = "balance", length=11, nullable=false)
	private Integer balance;
	
	@Column(name = "role", length=11, nullable=false)
	private Integer role;
	
	@Basic(optional = false)
	@Column(name = "created_at",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "status", length=11, nullable=false)
	private Integer status;
	
}
