package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.AuthorDto;
import com.Faraday.Library.entity.AuthorEntity;
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
	
//	public CategoryEntity convertToCategoryEntity(CategoryDto dto) {
//		CategoryEntity categoryEntity = new CategoryEntity();
//
//		categoryEntity.setCategoryCode(dto.getCategoryCode());
//		categoryEntity.setCategoryName(dto.getCategoryName());
//		categoryEntity.setStatus(1);
//		return categoryEntity;
//	}
	
	@Override
	public List<CategoryEntity> getAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findId();
	}


//	@Override
//	public CategoryEntity post(CategoryDto dto) {
//		// TODO Auto-generated method stub
//		CategoryEntity categoryEntity = convertToCategoryEntity(dto);
//		categoryRepository.save(categoryEntity);
//		return categoryEntity;
//	}

	@Override
	public CategoryEntity post(CategoryDto dto) {
		CategoryEntity category = new CategoryEntity();
		category.setCategoryCode("");
		category.setCategoryName(dto.getCategoryName());
		category.setStatus(1);
		categoryRepository.save(category);

		String kodeKategori = "";
		Integer categoryId = category.getId();
		if(categoryId.toString().length() == 1) kodeKategori = "BC00" + categoryId.toString();
		else if (categoryId.toString().length() == 2) kodeKategori = "BC0" + categoryId.toString();
		else if (categoryId.toString().length() == 3) kodeKategori = "BC" + categoryId.toString();
		category.setCategoryCode(kodeKategori);
		categoryRepository.save(category);
		return category;
	}


	@Override
	public CategoryEntity update(Integer id, CategoryDto dto) {
		// TODO Auto-generated method stub
		CategoryEntity categoryEntity = categoryRepository.findById(id).get();
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
