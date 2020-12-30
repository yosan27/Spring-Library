package com.Faraday.Library.dto;

import java.sql.Date;

public class RentDto {
	private String rentCode;
	private Date dateBorrow;
	private Date dueDate;
	private Date dateReturn;
	private Integer status;
	private String userCode;
	private String bookCode;
	
	public RentDto() {
		super();
	}
	
	public RentDto(String rentCode, Date dateBorrow, Date dueDate, Date dateReturn, Integer status, String userCode,
			String bookCode) {
		super();
		this.rentCode = rentCode;
		this.dateBorrow = dateBorrow;
		this.dueDate = dueDate;
		this.dateReturn = dateReturn;
		this.status = status;
		this.userCode = userCode;
		this.bookCode = bookCode;
	}

	public String getRentCode() {
		return rentCode;
	}

	public void setRentCode(String rentCode) {
		this.rentCode = rentCode;
	}

	public Date getDateBorrow() {
		return dateBorrow;
	}

	public void setDateBorrow(Date dateBorrow) {
		this.dateBorrow = dateBorrow;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
