package com.insurancemanagementsystem.service;

import com.insurancemanagementsystem.model.Policy;

public interface PolicyService {
    Policy getPolicyById(String policyId);
    void createPolicy(Policy policy);
    void updatePolicy(Policy policy);
    void deletePolicy(String policyId);
}