package com.insurancemanagementsystem.service;

import com.insurancemanagementsystem.exception.ClaimNotFoundException;
import com.insurancemanagementsystem.model.Claim;
import com.insurancemanagementsystem.model.ClaimStatus;
import com.insurancemanagementsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.insurancemanagementsystem.repository.ClaimRepository;

import java.nio.file.AccessDeniedException;

@Service
@Transactional
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;
    private final UserService userService;

    @Autowired
    public ClaimServiceImpl(ClaimRepository claimRepository, UserService userService) {
        this.claimRepository = claimRepository;
        this.userService = userService;
    }

    @Override
    public Claim getClaimById(Long claimId) throws ClaimNotFoundException {
        return claimRepository.findById(claimId)
                .orElseThrow(() -> new ClaimNotFoundException("Claim not found with ID: " + claimId));
    }

    @Override
    public Claim createClaim(Claim claim, String username) throws AccessDeniedException {
        User user = userService.getUserByUsername(username);
        if (!user.isAdmin() && !user.getUserId().equals(claim.getPolicyHolder().getUserId())) {
            throw new AccessDeniedException("Access denied: user is not an administrator or the policy holder");
        }
        claim.setId(null);
        claim.setStatus(ClaimStatus.PENDING);
        return claimRepository.save(claim);
    }

    @Override
    public Claim updateClaim(Long claimId, Claim claim, String username) throws ClaimNotFoundException, AccessDeniedException {
        Claim existingClaim = getClaimById(claimId);
        User user = userService.getUserByUsername(username);
        if (!user.isAdmin() && !user.getUserId().equals(existingClaim.getPolicyHolder().getUserId()) && !user.getUserId().equals(claim.getPolicyHolder().getUserId())) {
            throw new AccessDeniedException("Access denied: user is not an administrator, the policy holder, or the claimant");
        }
        claim.setId(existingClaim.getId());
        claim.setStatus(existingClaim.getStatus());
        return claimRepository.save(claim);
    }

    @Override
    public void deleteClaim(Long claimId, String username) throws ClaimNotFoundException, AccessDeniedException {
        Claim claim = getClaimById(claimId);
        User user = userService.getUserByUsername(username);
        if (!user.isAdmin()) {
            throw new AccessDeniedException("Access denied: user is not an administrator");
        }
        claimRepository.deleteById(claimId);
    }
}