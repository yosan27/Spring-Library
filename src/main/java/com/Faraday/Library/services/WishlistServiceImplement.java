package com.Faraday.Library.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Faraday.Library.dto.WishlistDto;
import com.Faraday.Library.entity.BookDetailsEntity;
import com.Faraday.Library.entity.BookEntity;
import com.Faraday.Library.entity.UserEntity;
import com.Faraday.Library.entity.WishlistEntity;
import com.Faraday.Library.repository.BookDetailsRepository;
import com.Faraday.Library.repository.BookRepository;
import com.Faraday.Library.repository.UserRepository;
import com.Faraday.Library.repository.WishlistRepository;

@Service
@Transactional
public class WishlistServiceImplement implements WishlistService {
	
	@Autowired
	private WishlistRepository wishRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookDetailsRepository bookDetailsRepository;
	
	@Override
	public WishlistEntity getWishlistById(Integer id) {
		// TODO Auto-generated method stub
		WishlistEntity wishlistEntity = wishRepository.findById(id).get();
		return wishlistEntity;
	}

	@Override
	public List<WishlistEntity> getWishlistByUserCode(String userCode) {
		// TODO Auto-generated method stub
		List<WishlistEntity> wishlistEntities = wishRepository.findByUserEntityUserCode(userCode);
		return wishlistEntities;
	}
	
	@Override
	public List<WishlistEntity> getByBookDetailsCode(String bookDetailsCode) {
		// TODO Auto-generated method stub
		List<WishlistEntity> wishlistEntities = wishRepository.findByBookDetailsEntityBookDetailCode(bookDetailsCode);
		return wishlistEntities;
	}

	@Override
	public WishlistEntity insertWish(WishlistDto dto) {
		// TODO Auto-generated method stub
		WishlistEntity wishlistEntity = convertToWishEntity(dto);
		wishRepository.save(wishlistEntity);
		return wishlistEntity;
	}

	@Override
	public WishlistEntity updateWish(Integer id, WishlistDto dto) {
		// TODO Auto-generated method stub
		WishlistEntity wishlistEntity = wishRepository.findById(id).get();
		UserEntity userEntity = userRepository.findByUserCode(dto.getUserCode());
		wishlistEntity.setUserEntity(userEntity);
		BookDetailsEntity bookDetailsEntity =  bookDetailsRepository.findByBookDetailCodeIgnoreCase(dto.getBookDetailsCode());
		wishlistEntity.setBookDetailsEntity(bookDetailsEntity);
		wishRepository.save(wishlistEntity);
		return wishlistEntity;
	}

	@Override
	public WishlistEntity deleteWish(Integer id) {
		// TODO Auto-generated method stub
		WishlistEntity wishlistEntity = wishRepository.findById(id).get();
		wishRepository.delete(wishlistEntity);
		return wishlistEntity;
	}
	
	private WishlistEntity convertToWishEntity(WishlistDto dto) {
		WishlistEntity wishlistEntity = new WishlistEntity();
		UserEntity userEntity = userRepository.findByUserCode(dto.getUserCode());
		wishlistEntity.setUserEntity(userEntity);
		BookDetailsEntity bookDetailsEntity =  bookDetailsRepository.findByBookDetailCodeIgnoreCase(dto.getBookDetailsCode());
		wishlistEntity.setBookDetailsEntity(bookDetailsEntity);
		
		return wishlistEntity;
	}

	
	
}
