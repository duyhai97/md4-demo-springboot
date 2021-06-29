package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerRepo repo;

    @Override
    public Iterable<Customer> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void save(Customer customer) {
        repo.save(customer);
    }

    @Override
    public void remove(Long id) {
        repo.deleteById(id);
    }
}
