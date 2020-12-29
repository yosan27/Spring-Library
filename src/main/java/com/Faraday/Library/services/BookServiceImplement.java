package com.Faraday.Library.services;

import com.Faraday.Library.dto.BookDto;
import com.Faraday.Library.entity.BookDetailsEntity;
import com.Faraday.Library.entity.BookEntity;
import com.Faraday.Library.entity.CategoryEntity;
import com.Faraday.Library.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImplement implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookDetailsRepository bookDetailsRepository;

    @Override
    public List<BookEntity> getAllBooks() {
        List<BookEntity> books = bookRepository.findAllActive();
        return books;
    }

    @Override
    public BookEntity getDetailBooks(String bookCode) {
        BookEntity book = bookRepository.findByBookCodeIgnoreCase(bookCode);
        if (book == null) {
            book = null;
            return book;
        }
        return book;
    }

    @Override
    public BookEntity post(BookDto dto) {
        BookEntity books = new BookEntity();
        books.setBookCode("B");
        books.setIsbn(dto.getIsbn());
        books.setPublishedDate(dto.getPublishedDate());
        books.setStatus(1);

//        CategoryEntity categoryEntity = categoryRepository.findByCategoryCode(dto.getCategoryCode());
        bookRepository.save(books);

        String kodeBuku = "B" + books.getId();
        books.setBookCode(kodeBuku);
        bookRepository.save(books);
        return books;
    }

    @Override
    public BookEntity put(String bookCode, BookDto dto) {
        return null;
    }

    @Override
    public BookEntity delete(String bookCode) {
        return null;
    }
}
