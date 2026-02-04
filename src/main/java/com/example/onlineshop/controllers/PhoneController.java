package com.example.onlineshop.controllers;

import com.example.onlineshop.entities.PhoneEntity;
import com.example.onlineshop.repositories.PhoneRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    private final PhoneRepository phoneRepo;

    public PhoneController(PhoneRepository phoneRepo) {
        this.phoneRepo = phoneRepo;
    }

    @GetMapping
    public List<PhoneEntity> getAll() {
        return phoneRepo.findAll();
    }

    @PostMapping
    public PhoneEntity create(@RequestBody PhoneEntity phone) {
        return phoneRepo.save(phone);
    }

    @GetMapping("/{id}")
    public PhoneEntity getOne(@PathVariable Integer id) {
        return phoneRepo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public PhoneEntity update(@PathVariable Integer id, @RequestBody PhoneEntity phone) {
        phone.setId(id);
        return phoneRepo.save(phone);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        phoneRepo.deleteById(id);
    }
}

