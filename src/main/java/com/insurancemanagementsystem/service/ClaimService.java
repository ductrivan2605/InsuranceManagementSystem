package com.insurancemanagementsystem.service;

import com.insurancemanagementsystem.exception.ClaimNotFoundException;
import com.insurancemanagementsystem.model.Claim;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.util.List;


public interface ClaimService {

    Claim getClaimById(String claimId) throws SQLException;

    void createClaim(Claim claim) throws Exception;

    void updateClaim(Claim claim) throws Exception;

    void deleteClaim(String claimId) throws Exception;

    List<Claim> getAssignedClaims();

    List<Claim> getFilteredClaims(String filter);

    void requestMoreInfo(int claimId);

    Claim proposeClaim(int claimId, Claim claim);
}