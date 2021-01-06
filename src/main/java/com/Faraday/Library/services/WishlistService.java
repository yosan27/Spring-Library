package com.Faraday.Library.services;

import java.util.List;

import com.Faraday.Library.dto.WishlistDto;
import com.Faraday.Library.entity.WishlistEntity;

public interface WishlistService {
	
	public WishlistEntity getWishlistById(Integer id);
	public List<WishlistEntity> getWishlistByUserCode(String userCode);
	public List<WishlistEntity> getByBookDetailsCode(String bookDetailsCode);
	public WishlistEntity insertWish(WishlistDto dto);
	public WishlistEntity updateWish(Integer id, WishlistDto dto);
	public WishlistEntity deleteWish(Integer id);
}
