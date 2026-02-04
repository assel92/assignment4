package com.example.onlineshop.repositories;

import com.example.onlineshop.entities.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<PhoneEntity, Integer> {
}

