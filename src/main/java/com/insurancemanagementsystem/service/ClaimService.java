package com.insurancemanagementsystem.service;

import com.insurancemanagementsystem.exception.ClaimNotFoundException;
import com.insurancemanagementsystem.model.Claim;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;


public interface ClaimService {

    Claim getClaimById(String claimId) throws SQLException;

    void createClaim(Claim claim) throws Exception;

    void updateClaim(Claim claim) throws Exception;

    void deleteClaim(String claimId) throws Exception;
}