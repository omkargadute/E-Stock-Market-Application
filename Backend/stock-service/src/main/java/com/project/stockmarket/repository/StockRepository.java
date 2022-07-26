package com.project.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.stockmarket.entity.Stock;

@Repository
public interface StockRepository extends MongoRepository<Stock, Integer> {
}
