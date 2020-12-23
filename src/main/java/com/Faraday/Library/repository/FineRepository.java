package com.Faraday.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.FineEntity;

@Repository
public interface FineRepository extends JpaRepository<FineEntity, Integer>{

}
