package com.Faraday.Library.dto;

public class CartDto {
	private Integer id;
	private String userCode;
	private String bookDetailsCode;
	
	public CartDto() {
		super();
	}

	public CartDto(Integer id, String userCode, String bookDetailsCode) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.bookDetailsCode = bookDetailsCode;
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

	public String getBookDetailsCode() {
		return bookDetailsCode;
	}

	public void setBookDetailsCode(String bookDetailsCode) {
		this.bookDetailsCode = bookDetailsCode;
	}
	
}
