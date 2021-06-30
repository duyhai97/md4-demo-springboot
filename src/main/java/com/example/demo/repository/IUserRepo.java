package com.example.demo.repository;


import com.example.demo.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String name);
}