package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.model.Claim;
import com.insurancemanagementsystem.model.User;
import com.insurancemanagementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SystemAdminController {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }
}