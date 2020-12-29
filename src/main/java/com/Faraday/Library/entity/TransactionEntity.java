package com.Faraday.Library.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "transaction_entity")
public class TransactionEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "transaction_date", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date date;
	
	@Column(name = "nominal", nullable = false)
	private Double nominal;
	
	@Column(name = "payment_method", nullable = false)
	private String paymentMethod;
	
	@Column(name = "payment_status", nullable = false)
	private Integer paymentStatus;
	
	@Column(name = "transaction_code", nullable = false, unique = true)
	private String transactionCode;

	@ManyToOne
	@JoinColumn(name = "user_code", nullable = false, unique = true, referencedColumnName = "user_code")
	private UserEntity userEntity;
	
//	@OneToOne
//	@JoinColumn(name = "rent_code", nullable = false, unique = true, referencedColumnName = "rent_code")
//	private String rentCode;
	
	
	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
}
