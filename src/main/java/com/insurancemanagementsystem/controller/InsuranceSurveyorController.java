package com.insurancemanagementsystem.controller;
import com.insurancemanagementsystem.model.Claim;
import com.insurancemanagementsystem.model.User;
import com.insurancemanagementsystem.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurance-surveyors")
public class InsuranceSurveyorController {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Autowired
    private ClaimService claimService;

    @GetMapping("/claims")
    public List<Claim> getAssignedClaims() throws Exception {
        // Implement logic to retrieve claims assigned to the logged-in surveyor
        return claimService.getAssignedClaims(); // Replace with actual logic
    }

    @GetMapping("/claims/{filter}")
    public List<Claim> getFilteredClaims(@PathVariable String filter) throws Exception {
        // Implement filtering logic based on the filter parameter (e.g., status, date)
        return claimService.getFilteredClaims(filter);
    }

    @GetMapping("/claims/{claimId}/request-info")
    public void requestMoreInfo(@PathVariable int claimId) throws Exception {
        claimService.requestMoreInfo(claimId); // Implement logic to request more info
    }

    @PostMapping("/claims/{claimId}/propose")
    public Claim proposeClaim(@PathVariable int claimId, @RequestBody Claim claim) throws Exception {
        return claimService.proposeClaim(claimId, claim);
    }

    // Add additional methods for functionalities like viewing claim details, etc.
}
