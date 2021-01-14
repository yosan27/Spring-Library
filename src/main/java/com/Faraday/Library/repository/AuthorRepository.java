package com.Faraday.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.AuthorEntity;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer>{

    AuthorEntity findByAuthorCode(String authorCode);
    
    @Query(value = "select * from author_entity where status = 1", nativeQuery = true)
    List<AuthorEntity> findActiveId();
}
