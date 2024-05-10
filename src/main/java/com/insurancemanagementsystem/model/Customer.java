package com.insurancemanagementsystem.model;

import java.util.List;

public abstract class Customer extends User {

    public Customer(String userId, String username, String password, String fullName, Role role, String userEmail) {
        super(userId, username, password, fullName, role, userEmail);
    }

    // Abstract methods to be implemented by subclasses (PolicyHolder, Dependent)
    public abstract List<Claim> getClaims();
    public abstract void setClaims(List<Claim> claims);

    @Override
    public abstract String getUserType();
}
