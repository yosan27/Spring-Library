package com.Faraday.Library.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.DonationEntity;

@Repository
public interface DonationRepository extends JpaRepository<DonationEntity, Integer>{
	List<DonationEntity> findByStatus (Integer status);
}
