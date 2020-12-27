package com.Faraday.Library.dto;

public class AuthorDto {
	private Integer id;
	private String authorCode;
	private String authorName;
	public AuthorDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthorDto(Integer id, String authorCode, String authorName) {
		super();
		this.id = id;
		this.authorCode = authorCode;
		this.authorName = authorName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthorCode() {
		return authorCode;
	}
	public void setAuthorCode(String authorCode) {
		this.authorCode = authorCode;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
	

}
