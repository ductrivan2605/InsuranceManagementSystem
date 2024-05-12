package com.insurancemanagementsystem.controller;


import com.insurancemanagementsystem.service.*;
import com.insurancemanagementsystem.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurance-managers")
public class InsuranceManagerController {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

}
