package com.insurancemanagementsystem.service;

import com.insurancemanagementsystem.model.Policy;

import java.util.List;

public interface PolicyService {

    List<Policy> getPoliciesByPolicyHolderId(int policyHolderId) throws Exception;

    // Add methods for functionalities like retrieving specific policies, etc.
}
