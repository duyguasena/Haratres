package com.example.Haratres.repository;

import com.example.Haratres.model.SizeProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeProductRepository extends JpaRepository<SizeProductVariant,Long> {
}
