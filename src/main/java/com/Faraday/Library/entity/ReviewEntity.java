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

import lombok.Data;

@Data
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
	@JoinColumn(name = "book_detail_code", referencedColumnName = "book_detail_code")
	private BookDetailsEntity bookDetailsEntity;
	
	@Column(name = "rate", nullable = false)
	private Integer rate;
	
	@Column(name = "review", length = 300, nullable = false)
	private String review;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "status")
	private Integer status;
	
	
	
	public ReviewEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewEntity(Integer id, UserEntity userEntity, BookDetailsEntity bookDetailsEntity, Integer rate, String review,
			Date date, Integer status) {
		super();
		this.id = id;
		this.userEntity = userEntity;
		this.bookDetailsEntity = bookDetailsEntity;
		this.rate = rate;
		this.review = review;
		this.date = date;
		this.status = status;
	}

	
	
}
