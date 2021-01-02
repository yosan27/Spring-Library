package com.Faraday.Library.dto;

public class CartDto {
	private Integer id;
	private String userCode;
	private String bookCode;
	
	public CartDto() {
		super();
	}

	public CartDto(Integer id, String userCode, String bookCode) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.bookCode = bookCode;
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



	public String getBookCode() {
		return bookCode;
	}



	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	
	

}
