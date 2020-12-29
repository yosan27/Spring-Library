package com.Faraday.Library.dto;

import java.util.Date;

public class BookDto {
    private Integer id;
    private String bookCode;
    private String categoryCode;
    private String publisherCode;
    private String authorCode;
    private String bookDetailCode;
    private String isbn;
    private Date publishedDate;
    private Integer status;

    public BookDto(Integer id, String bookCode, String categoryCode, String publisherCode, String authorCode, String bookDetailCode, String isbn, Date publishedDate, Integer status) {
        this.id = id;
        this.bookCode = bookCode;
        this.categoryCode = categoryCode;
        this.publisherCode = publisherCode;
        this.authorCode = authorCode;
        this.bookDetailCode = bookDetailCode;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.status = status;
    }

    public BookDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getPublisherCode() {
        return publisherCode;
    }

    public void setPublisherCode(String publisherCode) {
        this.publisherCode = publisherCode;
    }

    public String getAuthorCode() {
        return authorCode;
    }

    public void setAuthorCode(String authorCode) {
        this.authorCode = authorCode;
    }

    public String getBookDetailCode() {
        return bookDetailCode;
    }

    public void setBookDetailCode(String bookDetailCode) {
        this.bookDetailCode = bookDetailCode;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
