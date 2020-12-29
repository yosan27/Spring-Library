package com.Faraday.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.CategoryEntity;


@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
	@Query(value = "select * from category_entity where status = 1", nativeQuery = true)
	List<CategoryEntity> findId();
}
