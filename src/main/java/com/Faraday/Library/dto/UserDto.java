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
}
