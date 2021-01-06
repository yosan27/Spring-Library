package com.Faraday.Library.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.DonationEntity;

@Repository
public interface DonationRepository extends JpaRepository<DonationEntity, Integer>{
	@Query(value = "select * from donation_entity where status = ?", nativeQuery = true)
	List<DonationEntity> findByStatus(Integer status);
}
