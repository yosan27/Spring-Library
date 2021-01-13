package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.AddBookDto;
import com.Faraday.Library.dto.BookDto;
import com.Faraday.Library.entity.BookEntity;

public interface BookService {
    List<BookEntity> getBooks();
    
    List<BookEntity> getCatalog();
    
    BookEntity getBookDetails(Integer id);

    BookEntity getBook(String bookCode);

    List<BookEntity> getPopular(String categoryCode);
    
    BookEntity post(BookDto dto);

    BookEntity postNew(AddBookDto dto);

    BookEntity put(String bookCode, BookDto dto);

    BookEntity delete(String bookCode);

    BookEntity getBookByBookDetailCode(String bookDetailCode);
    
    BookEntity updateStatus(String bookCode, BookDto dto);
    
    List<BookEntity> getNewBooks();
}
