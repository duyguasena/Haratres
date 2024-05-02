package com.example.Haratres.repository;

import com.example.Haratres.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository  extends JpaRepository<Stock,Long> {
}
