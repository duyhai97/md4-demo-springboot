package com.example.demo.service;

import com.example.demo.model.AppUser;

public interface IUserService {
    AppUser getUserByName(String name);
}
