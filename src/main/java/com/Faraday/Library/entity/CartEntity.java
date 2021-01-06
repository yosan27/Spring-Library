package com.Faraday.Library.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_entity")
public class CartEntity implements Serializable {
	
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
	
	public CartEntity() {
		super();
	}
	
	
	public CartEntity(Integer id, UserEntity userEntity, BookDetailsEntity bookDetailsEntity) {
		super();
		this.id = id;
		this.userEntity = userEntity;
		this.bookDetailsEntity = bookDetailsEntity;
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


	public BookDetailsEntity getBookDetailsEntity() {
		return bookDetailsEntity;
	}


	public void setBookDetailsEntity(BookDetailsEntity bookDetailsEntity) {
		this.bookDetailsEntity = bookDetailsEntity;
	}


	
	
}
