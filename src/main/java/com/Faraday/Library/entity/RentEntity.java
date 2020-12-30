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

@SuppressWarnings("serial")
@Entity
@Table(name = "rent_entity")
public class RentEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "rent_code", nullable = false)
	private String rentCode;
	
	@Column(name = "date_borrow")
	private Date dateBorrow;
	
	@Column(name = "due_date")
	private Date dueDate;
	
	@Column(name = "date_return")
	private Date dateReturn;
	
	@Column(name = "status")
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "user_code", referencedColumnName = "user_code")
	private UserEntity userEntity;
	
	@ManyToOne
	@JoinColumn(name = "book_code", referencedColumnName = "book_code")
	private BookEntity bookEntity;

	public RentEntity() {
		super();
	}
	
	public RentEntity(Integer id, String rentCode, Date dateBorrow, Date dueDate, Date dateReturn, Integer status,
			UserEntity userEntity, BookEntity bookEntity) {
		super();
		this.id = id;
		this.rentCode = rentCode;
		this.dateBorrow = dateBorrow;
		this.dueDate = dueDate;
		this.dateReturn = dateReturn;
		this.status = status;
		this.userEntity = userEntity;
		this.bookEntity = bookEntity;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRentCode() {
		return rentCode;
	}

	public void setRentCode(String rentCode) {
		this.rentCode = rentCode;
	}

	public Date getDateBorrow() {
		return dateBorrow;
	}

	public void setDateBorrow(Date dateBorrow) {
		this.dateBorrow = dateBorrow;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
}
