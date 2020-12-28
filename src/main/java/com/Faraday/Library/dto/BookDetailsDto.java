package com.Faraday.Library.dto;


public class BookDetailsDto {

    private Integer id;
    private String bookDetailCode;
    private String bookTitle;
    private String bookSubtitle;
    private String description;
    private String cover;
    private Integer numberOfPages;
    private String language;
    private Integer isActive;

    public BookDetailsDto(Integer id, String bookDetailCode, String bookTitle, String bookSubtitle, String description, String cover, Integer numberOfPages, String language, Integer isActive) {
        this.id = id;
        this.bookDetailCode = bookDetailCode;
        this.bookTitle = bookTitle;
        this.bookSubtitle = bookSubtitle;
        this.description = description;
        this.cover = cover;
        this.numberOfPages = numberOfPages;
        this.language = language;
        this.isActive = isActive;
    }

    public BookDetailsDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookDetailCode() {
        return bookDetailCode;
    }

    public void setBookDetailCode(String bookDetailCode) {
        this.bookDetailCode = bookDetailCode;
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

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}
