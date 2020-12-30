package com.Faraday.Library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Faraday.Library.dto.CategoryDto;
import com.Faraday.Library.entity.CategoryEntity;
import com.Faraday.Library.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImplement implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public CategoryEntity convertToCategoryEntity(CategoryDto dto) {
		CategoryEntity categoryEntity = new CategoryEntity();
		
		categoryEntity.setCategoryCode(dto.getCategoryCode());
		categoryEntity.setCategoryName(dto.getCategoryName());
		categoryEntity.setStatus(1);
		return categoryEntity;
	}
	
	@Override
	public List<CategoryEntity> getAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findId();
	}


	@Override
	public CategoryEntity post(CategoryDto dto) {
		// TODO Auto-generated method stub
		CategoryEntity categoryEntity = convertToCategoryEntity(dto);
		categoryRepository.save(categoryEntity);
		return categoryEntity;
	}


	@Override
	public CategoryEntity update(Integer id, CategoryDto dto) {
		// TODO Auto-generated method stub
		CategoryEntity categoryEntity = categoryRepository.findById(id).get();
		categoryEntity.setCategoryCode(dto.getCategoryCode());
		categoryEntity.setCategoryName(dto.getCategoryName());
		categoryRepository.save(categoryEntity);
		return categoryEntity;
	}


	@Override
	public CategoryEntity delete(Integer id) {
		// TODO Auto-generated method stub
		CategoryEntity categoryEntity = categoryRepository.findById(id).get();
		categoryEntity.setStatus(0);
		return categoryEntity;
	}
	
	
}
