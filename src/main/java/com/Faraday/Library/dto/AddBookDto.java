package com.Faraday.Library.dto;

import java.util.Date;

public class AddBookDto {
    private String authorName;
    private String bookTitle;
    private String bookSubtitle;
    private String description;
    private String cover;
    private Integer numberOfPages;
    private String language;
    private String categoryName;
    private String publisherName;
    private String address;
    private String isbn;
    private Date publishedDate;

    private String bookCode;
    private String categoryCode;
    private String publisherCode;
    private String authorCode;
    private String bookDetailCode;

    public AddBookDto(String authorName, String bookTitle, String bookSubtitle, String description, String cover, Integer numberOfPages, String language, String categoryName, String publisherName, String address, String isbn, Date publishedDate, String bookCode, String categoryCode, String publisherCode, String authorCode, String bookDetailCode) {
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.bookSubtitle = bookSubtitle;
        this.description = description;
        this.cover = cover;
        this.numberOfPages = numberOfPages;
        this.language = language;
        this.categoryName = categoryName;
        this.publisherName = publisherName;
        this.address = address;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.bookCode = bookCode;
        this.categoryCode = categoryCode;
        this.publisherCode = publisherCode;
        this.authorCode = authorCode;
        this.bookDetailCode = bookDetailCode;
    }

    public AddBookDto() {
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookSubtitle() {
        return bookSubtitle;
    }

    public void setBookSubtitle(String bookSubtitle) {
        this.bookSubtitle = bookSubtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
}
