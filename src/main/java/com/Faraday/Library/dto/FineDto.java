package com.Faraday.Library.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FineDto {
	private Integer id;
	private String fineCode;
	private String fineType;
	private Double nominal;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date validFrom;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date validTo;
	
	
	public FineDto(Integer id, String fineCode, String fineType, Double nominal, Date validFrom, Date validTo) {
		super();
		this.id = id;
		this.fineCode = fineCode;
		this.fineType = fineType;
		this.nominal = nominal;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}


	public FineDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFineCode() {
		return fineCode;
	}


	public void setFineCode(String fineCode) {
		this.fineCode = fineCode;
	}


	public String getFineType() {
		return fineType;
	}


	public void setFineType(String fineType) {
		this.fineType = fineType;
	}


	public Double getNominal() {
		return nominal;
	}


	public void setNominal(Double nominal) {
		this.nominal = nominal;
	}


	public Date getValidFrom() {
		return validFrom;
	}


	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}


	public Date getValidTo() {
		return validTo;
	}


	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
}
