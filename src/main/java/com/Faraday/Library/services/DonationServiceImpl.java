package com.Faraday.Library.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Faraday.Library.dto.DonationDto;
import com.Faraday.Library.entity.CategoryEntity;
import com.Faraday.Library.entity.DonationEntity;
import com.Faraday.Library.entity.UserEntity;
import com.Faraday.Library.repository.CategoryRepository;
import com.Faraday.Library.repository.DonationRepository;
import com.Faraday.Library.repository.UserRepository;

@Service
@Transactional
public class DonationServiceImpl implements DonationService{
	@Autowired
	private DonationRepository donationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<DonationEntity> getAll(){
		List<DonationEntity> donationEntities = donationRepository.findAll();
		return donationEntities;
	}
	
	@Override
	public DonationEntity getById(Integer id) {
		DonationEntity donationEntity = donationRepository.findById(id).get();
		return donationEntity;
	}
	
	@Override
	public List<DonationEntity> getByStatus( Integer status){
		List<DonationEntity> donationEntities = donationRepository.findByStatus(status);
		return donationEntities;
	}
	
	@Override
	public DonationEntity insert(DonationDto dto) {
		Integer id  = 0;
		
		DonationEntity donationEntity = new DonationEntity();
		CategoryEntity categoryEntity = categoryRepository.findByCategoryCodeIgnoreCase(dto.getCategoryCode());
		UserEntity userEntity = userRepository.findByUserCode(dto.getUserCode());
		
		donationEntity.setAuthor(dto.getAuthor());
		donationEntity.setBookTitle(dto.getBookTitle());
		donationEntity.setDescription(dto.getDescription());
		donationEntity.setYear(dto.getYear());
		donationEntity.setPhoto(dto.getPhoto());
		donationEntity.setStatus(1);
		donationEntity.setCategoryEntity(categoryEntity);
		donationEntity.setUserEntity(userEntity);
		donationRepository.save(donationEntity);
		
		return donationEntity;
	}
	
	@Override
	public DonationEntity updateStatus(Integer id, DonationDto dto) {
		DonationEntity donationEntity = donationRepository.findById(id).get();
		donationEntity.setStatus(dto.getStatus());// 1=Pending, 2=Accepted, 3=Rejected
		donationRepository.save(donationEntity);
		return donationEntity;
	}
	
	@Override
	public DonationEntity delete(Integer id) {
		DonationEntity donationEntity = donationRepository.findById(id).get();
		
		if (donationEntity == null) {
			donationEntity = null;
			return donationEntity;
		}
		
		donationEntity.setStatus(3);
		donationRepository.save(donationEntity);
		
		return donationEntity;
	}
}
