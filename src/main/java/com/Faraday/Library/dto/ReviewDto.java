package com.Faraday.Library.dto;

import java.sql.Date;

public class ReviewDto {
	private String user_code;
	private String book_code;
	private Integer rate;
	private String review;
	private String date;
	
	public ReviewDto(String user_code, String book_code, Integer rate, String review, String date) {
		super();
		this.user_code = user_code;
		this.book_code = book_code;
		this.rate = rate;
		this.review = review;
		this.date = date;
	}
	
	public String getBook_code() {
		return book_code;
	}
	public void setBook_code(String book_code) {
		this.book_code = book_code;
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
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
}


