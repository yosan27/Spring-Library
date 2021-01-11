package com.Faraday.Library.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DonationDto {
	private String bookTitle;
	private String author;
	private String year;
	private String description;
	private String photo;
	private Integer status;
	private String categoryCode;
	private String userCode;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date date;
	
	public DonationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonationDto(String bookTitle, Date date, String author, String year, String description, String photo, Integer status,
			String categoryCode, String userCode) {
		super();
		this.bookTitle = bookTitle;
		this.author = author;
		this.year = year;
		this.description = description;
		this.photo = photo;
		this.status = status;
		this.categoryCode = categoryCode;
		this.userCode = userCode;
		this.date = date;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getYear() {
		return year;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	
}
