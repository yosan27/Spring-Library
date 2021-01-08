package com.Faraday.Library.dto;

import java.sql.Date;

public class ReviewDto {
	private String userCode;
	private String bookCode;
	private Integer rate;
	private String review;
	private String date;
	
	public ReviewDto(String userCode, String bookCode, Integer rate, String review, String date) {
		super();
		this.userCode = userCode;
		this.bookCode = bookCode;
		this.rate = rate;
		this.review = review;
		this.date = date;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	
}


