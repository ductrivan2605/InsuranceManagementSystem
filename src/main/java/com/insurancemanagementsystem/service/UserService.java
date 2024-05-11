package com.insurancemanagementsystem.service;

import com.insurancemanagementsystem.model.User;

public interface UserService {
    User authenticateUser(String username, String password) throws Exception;

    User getUserByUsername(String username);
}