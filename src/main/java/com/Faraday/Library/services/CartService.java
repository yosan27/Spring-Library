package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.CartDto;
import com.Faraday.Library.entity.CartEntity;

public interface CartService {
	
	public CartEntity getById(Integer id);
	public List<CartEntity> getByUserCode(String userCode);
	public List<CartEntity> getByBookCode(String bookCode);
	public CartEntity insertCart(CartDto dto);
	public CartEntity updateCart(Integer id, CartDto dto);
	public CartEntity deleteCart(Integer id);
}
