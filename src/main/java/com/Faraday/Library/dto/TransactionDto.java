package com.Faraday.Library.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransactionDto {
	private Integer id;
	private String userCode;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date date;
	
	private Double nominal;
	private String paymentMethod;
	private Integer paymentStatus;
	private String transactionCode;
	
	
	public TransactionDto(Integer id, String userCode, Date date, Double nominal, String paymentMethod,
			Integer paymentStatus, String transactionCode) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.date = date;
		this.nominal = nominal;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.transactionCode = transactionCode;
	}


	public TransactionDto() {
		super();
	}


	public String getTransactionCode() {
		return transactionCode;
	}


	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Double getNominal() {
		return nominal;
	}


	public void setNominal(Double nominal) {
		this.nominal = nominal;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public Integer getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
