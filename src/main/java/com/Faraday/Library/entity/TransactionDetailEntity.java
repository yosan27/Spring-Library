package com.Faraday.Library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_detail_entity")
public class TransactionDetailEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "detail_code", nullable = false, unique = true)
	private String detailCode;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "debet", nullable = false)
	private Double debet;
	
	@Column(name = "kredit", nullable = false)
	private Double kredit;
	
	@ManyToOne
	@JoinColumn(name = "transaction_code", nullable = false, unique = true, referencedColumnName = "transaction_code")
	private TransactionEntity transactionEntity;
	
	@OneToOne
	@JoinColumn(name = "fine_code", unique = true, referencedColumnName = "fine_code")
	private FineEntity fineEntity;


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


	public TransactionEntity getTransactionEntity() {
		return transactionEntity;
	}


	public void setTransactionEntity(TransactionEntity transactionEntity) {
		this.transactionEntity = transactionEntity;
	}


	public FineEntity getFineEntity() {
		return fineEntity;
	}


	public void setFineEntity(FineEntity fineEntity) {
		this.fineEntity = fineEntity;
	}
}