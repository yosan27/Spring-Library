package com.Faraday.Library.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ReviewDto {
	private String userCode;
	private String bookDetailCode;
	private Integer rate;
	private String review;
	private Date date;
	
	public ReviewDto(String userCode, String bookDetailCode, Integer rate, String review, Date date) {
		super();
		this.userCode = userCode;
		this.bookDetailCode = bookDetailCode;
		this.rate = rate;
		this.review = review;
		this.date = date;
	}

	public ReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}


