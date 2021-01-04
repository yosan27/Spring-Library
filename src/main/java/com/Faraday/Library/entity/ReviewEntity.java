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
import javax.persistence.Table;

@Entity
@Table(name = "review_entity")
public class ReviewEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_code", referencedColumnName = "user_code")
	private UserEntity userEntity;
	
	@ManyToOne
	@JoinColumn(name = "book_code", referencedColumnName = "book_code")
	private BookEntity bookEntity;
	
	@Column(name = "rate", nullable = false)
	private Integer rate;
	
	@Column(name = "review", length = 11, nullable = false)
	private String review;
	
	@Column(name = "date", nullable = false)
	private String date;
	
	@Column(name = "status")
	private Integer status;
	
	
	
	public ReviewEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewEntity(Integer id, UserEntity userEntity, BookEntity bookEntity, Integer rate, String review,
			String date, Integer status) {
		super();
		this.id = id;
		this.userEntity = userEntity;
		this.bookEntity = bookEntity;
		this.rate = rate;
		this.review = review;
		this.date = date;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public BookEntity getBookEntity() {
		return bookEntity;
	}

	public void setBookEntity(BookEntity bookEntity) {
		this.bookEntity = bookEntity;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
