package com.Faraday.Library.repository;

import com.Faraday.Library.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    BookEntity findByBookCodeIgnoreCase(String bookCode);

    @Query(value = "SELECT * FROM book_entity WHERE status = 1", nativeQuery = true)
    List<BookEntity> findAllActive();

    //get last code
    @Query(value = "select book_code from book_entity order by id desc limit 1", nativeQuery = true)
    String findLastCode();
}
