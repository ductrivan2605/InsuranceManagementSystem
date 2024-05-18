package com.insurancemanagementsystem.service;

import com.insurancemanagementsystem.model.Role;
import com.insurancemanagementsystem.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Role authenticateUser(String username, String password) throws Exception;

    User getUserByUsername(String username);


    List<User> getAllUser();

    Optional<User> getUserById(String id);

    void deleteUser(String id);

    void createUser(User user);

    User updateUser(User user);

}