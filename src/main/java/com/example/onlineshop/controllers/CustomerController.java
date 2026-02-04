package com.example.onlineshop.controllers;

import com.example.onlineshop.entities.CustomerEntity;
import com.example.onlineshop.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerRepository customerRepo;

    public CustomerController(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping
    public List<CustomerEntity> getAllCustomers() {
        return customerRepo.findAll();
    }

    @GetMapping("/{id}")
    public CustomerEntity getCustomerById(@PathVariable Integer id) {
        return customerRepo.findById(id).orElse(null);
    }

    @PostMapping
    public CustomerEntity createCustomer(@RequestBody CustomerEntity customer) {
        return customerRepo.save(customer);
    }

    @PutMapping("/{id}")
    public CustomerEntity updateCustomer(@PathVariable Integer id, @RequestBody CustomerEntity customer) {
        customer.setId(id);
        return customerRepo.save(customer);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerRepo.deleteById(id);
        return "Customer deleted";
    }
}


