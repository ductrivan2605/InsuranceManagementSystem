package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.service.UserService;
import com.insurancemanagementsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Assuming Spring MVC

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        return userService.loginUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) throws Exception {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) throws Exception {
        return userService.updateUser(id, user);
    }
}
