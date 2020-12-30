package com.Faraday.Library.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "fine_entity")
public class FineEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "fine_code", nullable = false, unique = true)
	private String fineCode;
	
	@Column(name = "fine_type", nullable = false)
	private String fineType;
	
	@Column(name = "nominal", nullable = false)
	private Double nominal;
	
	@Column(name = "valid_from", nullable = false)
	@JsonFormat(pattern ="dd/MM/yyy")
	private Date validFrom;
	
	@Column(name = "valid_to", nullable = false)
	@JsonFormat(pattern ="dd/MM/yyy")
	private Date validTo;

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
