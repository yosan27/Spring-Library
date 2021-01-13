package com.Faraday.Library.services;

import com.Faraday.Library.dto.BookDetailsDto;
import com.Faraday.Library.dto.StatusMessageDto;
import com.Faraday.Library.entity.BookDetailsEntity;
import com.Faraday.Library.repository.BookDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BookDetailsServiceImplement implements BookDetailsService{

    @Autowired
    private BookDetailsRepository bookDetailRepository;

    @Override
    public List<BookDetailsEntity> getAllDetailBooks() {
        List<BookDetailsEntity> books = bookDetailRepository.findAllActive();
        return books;
    }

    @Override
    public BookDetailsEntity getDetailBooks(String bookDetailCode) {
        BookDetailsEntity books = bookDetailRepository.findByBookDetailCodeIgnoreCase(bookDetailCode);
        if (books == null) {
            books = null;
            return books;
        }
        return books;
    }

    @Override
    public BookDetailsEntity post(BookDetailsDto dto) {
        BookDetailsEntity books = new BookDetailsEntity();
        books.setBookDetailCode("BD");
        books.setBookTitle(dto.getBookTitle());
        books.setBookSubtitle(dto.getBookSubtitle());
        books.setDescription(dto.getDescription());

//        try {
//
//            Long unixTime = Instant.now().getEpochSecond();
//            System.out.println(unixTime);
//            byte[] bookImage = Base64.getMimeDecoder().decode(dto.getCover());
//            System.out.println(dto.getCover());
//
////            Map uploadResult=cloudinary.upload("../../../../../../../Todidewantoro/Downloads/image.png", ObjectUtils.emptyMap());
////            System.out.println(uploadResult);
//
//            Map uploadResult = cloudinary.upload(bookImage,
//                    ObjectUtils.asMap(
//                            "publicId", "Book",
//                            "timestamp", unixTime.toString()));
//
//            books.setCover(uploadResult.get("url").toString());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }

        books.setCover(dto.getCover());
        books.setNumberOfPages(dto.getNumberOfPages());
        books.setLanguage(dto.getLanguage());
        books.setIsActive(1);
        bookDetailRepository.save(books);

        String kodeDetailBuku = "";
        Integer bookId = books.getId();
        if(bookId.toString().length() == 1) kodeDetailBuku = "BD00" + bookId.toString();
        else if (bookId.toString().length() == 2) kodeDetailBuku = "BD0" + bookId.toString();
        else if (bookId.toString().length() == 3) kodeDetailBuku = "BD" + bookId.toString();
        books.setBookDetailCode(kodeDetailBuku);
        bookDetailRepository.save(books);
        return books;
    }

    @Override
    public BookDetailsEntity put(String bookDetailCode, BookDetailsDto dto) {
        BookDetailsEntity books = bookDetailRepository.findByBookDetailCodeIgnoreCase(bookDetailCode);

        if (books == null) {
            books = null;
            return books;
        }

        books.setBookDetailCode(dto.getBookDetailCode());
        books.setBookTitle(dto.getBookTitle());
        books.setBookSubtitle(dto.getBookSubtitle());
        books.setDescription(dto.getDescription());
        books.setCover(dto.getCover());
        books.setNumberOfPages(dto.getNumberOfPages());
        books.setLanguage(dto.getLanguage());
        bookDetailRepository.save(books);
        return books;
    }

    @Override
    public BookDetailsEntity delete(String bookDetailCode) {
        BookDetailsEntity books = bookDetailRepository.findByBookDetailCodeIgnoreCase(bookDetailCode);

        if (books == null) {
            books = null;
            return books;
        }

        books.setIsActive(0);
        bookDetailRepository.save(books);

        return books;
    }
}