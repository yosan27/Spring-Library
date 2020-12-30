package com.Faraday.Library.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "publisher_entity")
public class PublisherEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "publisher_code", unique = true, nullable = false)
	private String publisherCode;
	
	@Column(name = "publisher_name")
	private String publisherName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "status")
	private Integer status;

	public PublisherEntity() {
		super();
	}
	
	public PublisherEntity(Integer id, String publisherCode, String publisherName, String address, Integer status) {
		super();
		this.id = id;
		this.publisherCode = publisherCode;
		this.publisherName = publisherName;
		this.address = address;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPublisherCode() {
		return publisherCode;
	}

	public void setPublisherCode(String publisherCode) {
		this.publisherCode = publisherCode;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}