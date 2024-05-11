package com.insurancemanagementsystem.repository;

import com.insurancemanagementsystem.model.Claim;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends CrudRepository<Claim, Long> {
}