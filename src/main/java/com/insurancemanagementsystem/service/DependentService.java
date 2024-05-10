package com.insurancemanagementsystem.service;

import com.insurancemanagementsystem.model.User;

import java.util.List;

public interface DependentService {
    List<User> getDependentsByPolicyOwnerId(int policyOwnerId) throws Exception;
}