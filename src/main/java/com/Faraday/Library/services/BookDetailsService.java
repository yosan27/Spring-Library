package com.Faraday.Library.services;

import com.Faraday.Library.dto.BookDetailsDto;
import com.Faraday.Library.entity.BookDetailsEntity;

import java.util.List;

public interface BookDetailsService {

    List<BookDetailsEntity> getAllDetailBooks();

    BookDetailsEntity getDetailBooks(String bookDetailCode);

    BookDetailsEntity post(BookDetailsDto dto);

    BookDetailsEntity put(String bookDetailCode, BookDetailsDto dto);

    BookDetailsEntity delete(String bookDetailCode);
}