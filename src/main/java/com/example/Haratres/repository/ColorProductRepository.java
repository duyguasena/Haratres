package com.example.Haratres.repository;

import com.example.Haratres.model.ColorProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColorProductRepository extends JpaRepository<ColorProductVariant,Long> {

}
