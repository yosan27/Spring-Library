package com.Faraday.Library.repository;

import com.Faraday.Library.entity.BookDetailsEntity;
import com.Faraday.Library.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDetailsRepository extends JpaRepository<BookDetailsEntity, Integer> {

//    BookDetailsEntity findByBookDetailCode(String bookDetailCode);

    @Query(value = "SELECT * FROM book_detail_entity WHERE is_active = 1", nativeQuery = true)
    List<BookDetailsEntity> findAllActive();

    //get last code
    @Query(value = "select book_detail_code from book_detail_entity order by id desc limit 1", nativeQuery = true)
    String findLastCode();

    @Query(value = "select book_detail_code from publisher_entity where=?", nativeQuery = true)
    BookDetailsEntity findLastCodeBookDetail(String bookDetailCode);
    
    BookDetailsEntity findByBookDetailCodeIgnoreCase(String bookDetailCode);

    //get last book detail
    @Query(value = "select * from book_detail_entity order by id desc limit 1", nativeQuery = true)
    List<BookDetailsEntity> getLastBookDetail();
}