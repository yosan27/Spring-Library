package com.Faraday.Library.dto;

public class PublisherDto {
	private String publisherCode;
	private String publisherName;
	private String address;
	
	public PublisherDto() {
		super();
	}
	
	public PublisherDto(String publisherCode, String publisherName, String address) {
		super();
		this.publisherCode = publisherCode;
		this.publisherName = publisherName;
		this.address = address;
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