package com.Faraday.Library.dto;

public class PublisherDto {
	private Integer id;
	private String publisherCode;
	private String publisherName;
	private String address;
	
	public PublisherDto() {
		super();
	}

	public PublisherDto(Integer id, String publisherCode, String publisherName, String address) {
		super();
		this.id = id;
		this.publisherCode = publisherCode;
		this.publisherName = publisherName;
		this.address = address;
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
}