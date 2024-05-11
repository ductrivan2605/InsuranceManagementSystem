package com.insurancemanagementsystem.service;

import com.insurancemanagementsystem.exception.ClaimNotFoundException;
import com.insurancemanagementsystem.model.Claim;

import java.nio.file.AccessDeniedException;


public interface ClaimService {

    Claim getClaimById(Long claimId) throws ClaimNotFoundException;

    Claim createClaim(Claim claim, String username) throws AccessDeniedException;

    Claim updateClaim(Long claimId, Claim claim, String username) throws ClaimNotFoundException, AccessDeniedException;

    void deleteClaim(Long claimId, String username) throws ClaimNotFoundException, AccessDeniedException;
}