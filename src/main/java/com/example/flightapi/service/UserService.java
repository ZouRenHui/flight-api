package com.example.flightapi.service;

import com.example.flightapi.entity.User;

public interface UserService {
    User createUser(User user);
    User userLogin(User user);
}
