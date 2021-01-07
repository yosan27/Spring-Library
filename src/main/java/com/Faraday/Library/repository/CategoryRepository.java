package com.Faraday.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.CategoryEntity;


@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

	CategoryEntity findByCategoryCodeIgnoreCase(String categoryCode);

	@Query(value = "select * from category_entity where status = 1", nativeQuery = true)
	List<CategoryEntity> findId();

	//get last code
	@Query(value = "select category_code from category_entity order by id desc limit 1", nativeQuery = true)
	String findLastCode();

	@Query(value = "select category_code from category_entity where=?", nativeQuery = true)
	CategoryEntity findLastCodeCategory(String categoryCode);
}
