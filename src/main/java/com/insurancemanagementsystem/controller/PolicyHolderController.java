package com.insurancemanagementsystem.controller;


import com.insurancemanagementsystem.model.Claim;
import com.insurancemanagementsystem.model.Policy;
import com.insurancemanagementsystem.model.User;
import com.insurancemanagementsystem.service.ClaimService;
import com.insurancemanagementsystem.service.PolicyService;
import com.insurancemanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policyholders")
public class PolicyHolderController {

    @Autowired
    private UserService userService;

    @Autowired
    private PolicyService policyService;

    @Autowired
    private ClaimService claimService;

    @GetMapping("/{userId}/policies")
    public List<Policy> getPoliciesByPolicyHolderId(@PathVariable int userId) throws Exception {
        return policyService.getPoliciesByPolicyHolderId(userId);
    }

    @GetMapping("/{userId}/dependents")
    public List<User> getDependentsByPolicyOwnerId(@PathVariable int userId) throws Exception {
        return userService.getDependentsByPolicyOwnerId(userId);
    }

    @PostMapping("/{userId}/claims")
    public Claim submitClaim(@PathVariable int userId, @RequestBody Claim claim) throws Exception {
        return claimService.submitClaim(claim, userId);
    }
}

