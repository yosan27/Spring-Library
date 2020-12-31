package com.Faraday.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.WishlistEntity;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistEntity, Integer>{
	List<WishlistEntity> findByUserEntityUserCode(String userCode);
	List<WishlistEntity> findByBookEntityBookCode(String bookCode);
}
