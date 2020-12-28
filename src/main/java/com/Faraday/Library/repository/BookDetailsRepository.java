package com.Faraday.Library.repository;

import com.Faraday.Library.entity.BookDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDetailsRepository extends JpaRepository<BookDetailsEntity, Integer> {

//    @Query(value = "SELECT * FROM book_detail WHERE is_active = true", nativeQuery = true)
//    List<BookDetailEntity> findAllActive();
//    }

    BookDetailsEntity findByBookDetailCodeIgnoreCase(String bookDetailCode);

    @Query(value = "SELECT * FROM book_detail WHERE is_active = 1", nativeQuery = true)
    List<BookDetailsEntity> findAllActive();
}