package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.CategoryDto;
import com.Faraday.Library.entity.CategoryEntity;

public interface CategoryService {
	List<CategoryEntity> getAll();
	CategoryEntity post(CategoryDto dto);
	CategoryEntity update(Integer id, CategoryDto dto);
	CategoryEntity delete(Integer id);
}
