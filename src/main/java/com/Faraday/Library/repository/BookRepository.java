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

    @Query(value = "SELECT * FROM book_entity WHERE category_code = ? AND status = 1 limit 3", nativeQuery = true)
    List<BookEntity> findPopular(String categoryCode);
    
    @Query(value = "SELECT * FROM book_entity WHERE status = 1 AND book_detail_code = ? order by id desc limit 1", nativeQuery = true)
    BookEntity findAllActiveByBookDetailCode(String bookDetailCode);
  
    @Query(value = "SELECT book_entity.id, book_entity.book_code, book_entity.isbn, book_entity.published_date, book_entity.status, book_entity.book_detail_code, book_detail_entity.book_title, book_detail_entity.cover, book_entity.author_code, author_entity.author_name,book_entity.category_code, category_entity.category_name, book_entity.publisher_code, publisher_entity.publisher_name FROM book_entity INNER JOIN book_detail_entity ON book_entity.book_detail_code = book_detail_entity.book_detail_code INNER JOIN author_entity ON book_entity.author_code = author_entity.author_code INNER JOIN category_entity ON book_entity.category_code = category_entity.category_code INNER JOIN publisher_entity ON book_entity.publisher_code = publisher_entity.publisher_code", nativeQuery = true)
    List<BookEntity> findCatalog();
    
    @Query(value = "SELECT book_entity.id, book_entity.book_code, book_entity.isbn, book_entity.published_date, book_entity.status, book_entity.book_detail_code, book_entity.author_code, book_entity.category_code, book_detail_entity.description, book_detail_entity.language, book_detail_entity.number_of_pages, book_detail_entity.book_subtitle, book_entity.publisher_code, publisher_entity.publisher_name FROM book_entity INNER JOIN book_detail_entity ON book_entity.book_detail_code = book_detail_entity.book_detail_code INNER JOIN publisher_entity ON book_entity.publisher_code = publisher_entity.publisher_code WHERE book_entity.id = ?", nativeQuery = true)
    BookEntity findBookDetails(Integer id);
    
   BookEntity findByBookCode(String bookCode);
   
   @Query(value = "SELECT * FROM book_entity ORDER BY published_date DESC LIMIT 12", nativeQuery = true)
   List<BookEntity> findNewBooks();
}
