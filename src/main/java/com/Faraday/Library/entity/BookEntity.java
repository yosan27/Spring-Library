package com.Faraday.Library.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_code",length = 255, unique = true, nullable = false)
    private String bookCode;

    @ManyToOne
    @JoinColumn(name = "category_code", referencedColumnName = "category_code")
    private CategoryEntity categoryEntity;

    @ManyToOne
    @JoinColumn(name = "publisher_code", referencedColumnName = "publisher_code")
    private PublisherEntity publisherEntity;

    @ManyToOne
    @JoinColumn(name = "author_code", referencedColumnName = "author_code")
    private AuthorEntity authorEntity;

    @ManyToOne
    @JoinColumn(name = "book_detail_code", referencedColumnName = "book_detail_code")
    private BookDetailsEntity bookDetailsEntity;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "published_date",length = 50, nullable = false)
    private Date publishedDate;

    @Column(name="status")
    @JsonIgnore
    private Integer status;

    public BookEntity(Integer id, String bookCode, CategoryEntity categoryEntity, PublisherEntity publisherEntity, AuthorEntity authorEntity, BookDetailsEntity bookDetailsEntity, String isbn, Date publishedDate, Integer status) {
        this.id = id;
        this.bookCode = bookCode;
        this.categoryEntity = categoryEntity;
        this.publisherEntity = publisherEntity;
        this.authorEntity = authorEntity;
        this.bookDetailsEntity = bookDetailsEntity;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.status = status;
    }

    public BookEntity() {
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

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public PublisherEntity getPublisherEntity() {
        return publisherEntity;
    }

    public void setPublisherEntity(PublisherEntity publisherEntity) {
        this.publisherEntity = publisherEntity;
    }

    public AuthorEntity getAuthorEntity() {
        return authorEntity;
    }

    public void setAuthorEntity(AuthorEntity authorEntity) {
        this.authorEntity = authorEntity;
    }

    public BookDetailsEntity getBookDetailsEntity() {
        return bookDetailsEntity;
    }

    public void setBookDetailsEntity(BookDetailsEntity bookDetailsEntity) {
        this.bookDetailsEntity = bookDetailsEntity;
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
