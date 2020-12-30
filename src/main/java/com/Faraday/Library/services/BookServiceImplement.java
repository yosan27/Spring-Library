package com.Faraday.Library.services;

import com.Faraday.Library.dto.BookDto;
import com.Faraday.Library.entity.*;
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
    public List<BookEntity> getBooks() {
        List<BookEntity> books = bookRepository.findAllActive();
        return books;
    }

    @Override
    public BookEntity getBook(String bookCode) {
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
        books.setBookCode("");
        books.setIsbn(dto.getIsbn());
        books.setPublishedDate(dto.getPublishedDate());
        books.setStatus(1);

        //masukkan kode kategori, publisher, author, bookDetail
        CategoryEntity categoryEntity = categoryRepository.findByCategory_codeIgnoreCase(dto.getCategoryCode());
        PublisherEntity publisherEntity = publisherRepository.findByPublisherCodeIgnoreCase(dto.getPublisherCode());
        AuthorEntity authorEntity = authorRepository.findByAuthorCodeIgnoreCase(dto.getAuthorCode());
        BookDetailsEntity bookDetailsEntity = bookDetailsRepository.findByBookDetailCodeIgnoreCase(dto.getBookDetailCode());

        books.setCategoryEntity(categoryEntity);
        books.setPublisherEntity(publisherEntity);
        books.setAuthorEntity(authorEntity);
        books.setBookDetailsEntity(bookDetailsEntity);
        bookRepository.save(books);

        String kodeBuku = "";

        Integer bookId = books.getId();
        bookId = publisherEntity.getId();
        if(bookId.toString().length() == 1) kodeBuku = "B00" + bookId.toString();
        else if (bookId.toString().length() == 2) kodeBuku = "B0" + bookId.toString();
        else if (bookId.toString().length() == 3) kodeBuku = "B" + bookId.toString();

        books.setBookCode(kodeBuku);
        bookRepository.save(books);
        return books;
    }

    @Override
    public BookEntity put(String bookCode, BookDto dto) {
        BookEntity books = bookRepository.findByBookCodeIgnoreCase(bookCode);
        CategoryEntity category = categoryRepository.findByCategory_codeIgnoreCase(dto.getCategoryCode());
        PublisherEntity publisher = publisherRepository.findByPublisherCodeIgnoreCase(dto.getPublisherCode());
        AuthorEntity author = authorRepository.findByAuthorCodeIgnoreCase(dto.getAuthorCode());
        BookDetailsEntity bookdetail = bookDetailsRepository.findByBookDetailCodeIgnoreCase(dto.getBookDetailCode());

        if (books == null) {
            books = null;
            return books;
        }

        books.setBookCode(dto.getBookCode());
        books.setIsbn(dto.getIsbn());
        books.setPublishedDate(dto.getPublishedDate());
        books.setCategoryEntity(category);
        books.setPublisherEntity(publisher);
        books.setAuthorEntity(author);
        books.setBookDetailsEntity(bookdetail);
        bookRepository.save(books);
        return books;
    }

    @Override
    public BookEntity delete(String bookCode) {
        BookEntity books = bookRepository.findByBookCodeIgnoreCase(bookCode);

        if (books == null) {
            books = null;
            return books;
        }

        books.setStatus(0);
        bookRepository.save(books);

        return books;
    }
}
