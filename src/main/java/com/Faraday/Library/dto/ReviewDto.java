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

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getBookDetailCode() {
		return bookDetailCode;
	}

	public void setBookDetailCode(String bookDetailCode) {
		this.bookDetailCode = bookDetailCode;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}


