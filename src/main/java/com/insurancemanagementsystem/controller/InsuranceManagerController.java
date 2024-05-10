package com.insurancemanagementsystem.controller;


import com.insurancemanagementsystem.service.*;
import com.insurancemanagementsystem.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurance-managers")
public class InsuranceManagerController {

    @Autowired
    private ClaimService claimService;

    @Autowired
    private UserService userService;

    @GetMapping("/claims")
    public List<Claim> getAllClaims() throws Exception {
        return claimService.getAllClaims();
    }

    @GetMapping("/claims/{filter}")
    public List<Claim> getFilteredClaims(@PathVariable String filter) throws Exception {
        // Implement filtering logic based on the filter parameter (e.g., status, date)
        return claimService.getFilteredClaims(filter);
    }

    @GetMapping("/surveyors")
    public List<User> getAllSurveyors() throws Exception {
        return userService.getUsersByRole("insurance_surveyor"); // Replace with your role name
    }

    @GetMapping("/claims/{claimId}/approve")
    public Claim approveClaim(@PathVariable int claimId) throws Exception {
        return claimService.approveClaim(claimId);
    }

    @GetMapping("/claims/{claimId}/reject")
    public Claim rejectClaim(@PathVariable int claimId) throws Exception {
        return claimService.rejectClaim(claimId);
    }
}
