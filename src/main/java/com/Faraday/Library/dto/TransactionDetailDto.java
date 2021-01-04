package com.Faraday.Library.dto;

public class TransactionDetailDto {
	private Integer id;
	private String detailCode;
	private String transactionCode;
	private String fineCode;
	private String rentCode;
	private String description;
	private Double debet;
	private Double kredit;
	
	
	public TransactionDetailDto(Integer id, String detailCode, String transactionCode, String fineCode,
			String description, Double debet, Double kredit, String rentCode) {
		super();
		this.id = id;
		this.detailCode = detailCode;
		this.transactionCode = transactionCode;
		this.fineCode = fineCode;
		this.description = description;
		this.debet = debet;
		this.kredit = kredit;
		this.rentCode = rentCode;
	}


	public TransactionDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getRentCode() {
		return rentCode;
	}


	public void setRentCode(String rentCode) {
		this.rentCode = rentCode;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDetailCode() {
		return detailCode;
	}


	public void setDetailCode(String detailCode) {
		this.detailCode = detailCode;
	}


	public String getTransactionCode() {
		return transactionCode;
	}


	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}


	public String getFineCode() {
		return fineCode;
	}


	public void setFineCode(String fineCode) {
		this.fineCode = fineCode;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getDebet() {
		return debet;
	}


	public void setDebet(Double debet) {
		this.debet = debet;
	}


	public Double getKredit() {
		return kredit;
	}


	public void setKredit(Double kredit) {
		this.kredit = kredit;
	}
}
