package com.Faraday.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Faraday.Library.entity.TransactionDetailEntity;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetailEntity, Integer> {

}
