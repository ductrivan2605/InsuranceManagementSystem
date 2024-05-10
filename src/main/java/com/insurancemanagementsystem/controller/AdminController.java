package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.model.Claim;
import com.insurancemanagementsystem.model.User;
import com.insurancemanagementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private ClaimService claimService;

    @Autowired
    private DependentService dependentService;

    // User Management Methods

    @GetMapping("/users")
    public List<User> getAllUsers() throws Exception {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable int userId) throws Exception {
        return userService.getUserById(userId);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User user) throws Exception {
        return userService.updateUser(userId, user);
    }

    // Policy and Dependent Management Methods (if applicable)

    // Claim Management Methods

    @GetMapping("/claims")
    public List<Claim> getAllClaims() throws Exception {
        return claimService.getAllClaims();
    }

    @GetMapping("/claims/{filter}")
    public List<Claim> getFilteredClaims(@PathVariable String filter) throws Exception {
        return claimService.getFilteredClaims(filter);
    }

    @GetMapping("/claims/{claimId}/total-amount")
    public double getTotalClaimedAmount(@PathVariable int claimId) throws Exception {
        return claimService.getTotalClaimedAmount(claimId); // Implement logic
    }

}