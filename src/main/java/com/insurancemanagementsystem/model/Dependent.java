package com.insurancemanagementsystem.model;

public class Dependent extends User{
    private String policyOwnerId;

    public Dependent(String userId, String username, String password, String fullName,
                     String email, String policyOwnerId) {
        super(userId, username, password, fullName, email);
        this.policyOwnerId = policyOwnerId;
    }
    public String getPolicyOwnerId(){
        return policyOwnerId;
    }

    public void setPolicyOwnerId(String policyOwnerId) {
        this.policyOwnerId = policyOwnerId;
    }

    @Override
    public String getUserType(){
        return "Dependent";
    }

}
