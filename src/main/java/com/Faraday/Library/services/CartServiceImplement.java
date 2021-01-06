package com.Faraday.Library.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Faraday.Library.dto.CartDto;
import com.Faraday.Library.entity.BookDetailsEntity;
import com.Faraday.Library.entity.BookEntity;
import com.Faraday.Library.entity.CartEntity;
import com.Faraday.Library.entity.UserEntity;
import com.Faraday.Library.repository.BookDetailsRepository;
import com.Faraday.Library.repository.BookRepository;
import com.Faraday.Library.repository.CartRepository;
import com.Faraday.Library.repository.UserRepository;

@Service
@Transactional
public class CartServiceImplement implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookDetailsRepository bookDetailsRepository;

	@Override
	public List<CartEntity> getByUserCode(String userCode) {
		// TODO Auto-generated method stub
		List<CartEntity> cartEntity = cartRepository.findByUserEntityUserCode(userCode);
		return cartEntity;
	}
	
	@Override
	public List<CartEntity> getByBookDetailsCode(String bookDetailsCode){
		// TODO Auto-generated method stub
		List<CartEntity> cartEntity = cartRepository.findByBookDetailsEntityBookDetailCode(bookDetailsCode);
		return cartEntity;
	}
	
	@Override
	public CartEntity getById(Integer id) {
		// TODO Auto-generated method stub
		CartEntity cartEntity = cartRepository.findById(id).get();
		return cartEntity;
	}

	@Override
	public CartEntity insertCart(CartDto dto) {
		// TODO Auto-generated method stub
		CartEntity cartEntity = convertToCartEntity(dto);
		cartRepository.save(cartEntity);
		return cartEntity;
	}

	@Override
	public CartEntity updateCart(Integer id, CartDto dto) {
		// TODO Auto-generated method stub
		CartEntity cartEntity = cartRepository.findById(id).get();
		UserEntity userEntity = userRepository.findByUserCode(dto.getUserCode());
		cartEntity.setUserEntity(userEntity);
		BookDetailsEntity bookDetailsEntity =  bookDetailsRepository.findByBookDetailCodeIgnoreCase(dto.getBookDetailsCode());
		cartEntity.setBookDetailsEntity(bookDetailsEntity);
		cartRepository.save(cartEntity);
		return cartEntity;
	}

	@Override
	public CartEntity deleteCart(Integer id) {
		// TODO Auto-generated method stub
		CartEntity cartEntity = cartRepository.findById(id).get();
		cartRepository.delete(cartEntity);
		return cartEntity;
	}
	
	private CartEntity convertToCartEntity(CartDto dto) {
		CartEntity cartEntity = new CartEntity();
		UserEntity userEntity = userRepository.findByUserCode(dto.getUserCode());
		cartEntity.setUserEntity(userEntity);
		BookDetailsEntity bookDetailsEntity =  bookDetailsRepository.findByBookDetailCodeIgnoreCase(dto.getBookDetailsCode());
		cartEntity.setBookDetailsEntity(bookDetailsEntity);
		return cartEntity;
	}

	



}
