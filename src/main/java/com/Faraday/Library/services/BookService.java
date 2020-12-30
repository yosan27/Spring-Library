package com.Faraday.Library.services;

import com.Faraday.Library.dto.BookDto;
import com.Faraday.Library.entity.BookEntity;

import java.util.List;

public interface BookService {
    List<BookEntity> getBooks();

    BookEntity getBook(String bookCode);

    BookEntity post(BookDto dto);

    BookEntity put(String bookCode, BookDto dto);

    BookEntity delete(String bookCode);
}
