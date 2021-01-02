package com.Faraday.Library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")

@Entity
@Table(name = "book_detail_entity")
public class BookDetailsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "book_detail_code",length = 255, nullable = false, unique=true)
    private String bookDetailCode;

    @Column(name = "book_title",length = 255, nullable = false)
    private String bookTitle;

    @Column(name = "book_subtitle",length = 255, nullable = false)
    private String bookSubtitle;

    @Column(name = "description",length = 900, nullable = false)
    private String description;

    @Column(name = "cover",length = 255, nullable = false)
    private String cover;

    @Column(name = "number_of_pages",length = 11, nullable = false)
    private Integer numberOfPages;

    @Column(name = "language",length = 255, nullable = false)
    private String language;

    @Column(name="is_active")
    @JsonIgnore
    private Integer isActive;

    public BookDetailsEntity(Integer id, String bookDetailCode, String bookTitle, String bookSubtitle, String description, String cover, Integer numberOfPages, String language, Integer isActive) {
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

    public BookDetailsEntity() {
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
