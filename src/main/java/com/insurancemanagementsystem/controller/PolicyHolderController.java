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
    private User user;

    public void setUser(User user) {
        this.user = user;
    }
}

