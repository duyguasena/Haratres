package com.example.Haratres.repository;

import com.example.Haratres.model.CartEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartEntryRepository extends JpaRepository<CartEntry,Long> {
}
