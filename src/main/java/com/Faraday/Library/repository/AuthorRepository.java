package com.Faraday.Library.repository;

import com.Faraday.Library.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.AuthorEntity;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer>{

    AuthorEntity findByAuthorCodeIgnoreCase(String authorCode);

    //get last code
    @Query(value = "select author_code from author_entity order by id desc limit 1", nativeQuery = true)
    String findLastCode();

    @Query(value = "select author_code from author_entity where=?", nativeQuery = true)
    AuthorEntity findLastCodeAuthor(String authorCode);
}
