package com.insurancemanagementsystem.service;

import com.insurancemanagementsystem.model.Claim;

import java.util.List;

public interface ClaimService {

    Claim submitClaim(Claim claim, int policyHolderId) throws Exception;

    List<Claim> getAllClaims() throws Exception;

    List<Claim> getFilteredClaims(String filter) throws Exception;

    Claim approveClaim(int claimId) throws Exception;

    Claim rejectClaim(int claimId) throws Exception;

    List<Claim> getAssignedClaims() throws Exception; // For Insurance Surveyors

    void requestMoreInfo(int claimId) throws Exception; // For Insurance Surveyors

    Claim proposeClaim(int claimId, Claim claim) throws Exception; // For Insurance Surveyors

    double getTotalClaimedAmount(int claimId) throws Exception; // For Admins

    // Add methods for functionalities like retrieving specific claims, etc.
}