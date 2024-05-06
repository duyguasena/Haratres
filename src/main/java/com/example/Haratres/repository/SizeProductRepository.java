package com.example.Haratres.repository;

import com.example.Haratres.model.SizeProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SizeProductRepository extends JpaRepository<SizeProductVariant,Long> {
    Optional<SizeProductVariant> findBySizeVariantCode(String sizeVariantCode);
}
