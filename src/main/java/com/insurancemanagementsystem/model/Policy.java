package com.insurancemanagementsystem.model;

import java.util.Date;

public class Policy {

    private int policyId;
    private int policyHolderId; // Foreign key referencing User (Policy Holder)
    private String policyType;
    private Date startDate;
    private Date endDate;


    public Policy(int policyId, int policyHolderId, String policyType, Date startDate, Date endDate) {
        this.policyId = policyId;
        this.policyHolderId = policyHolderId;
        this.policyType = policyType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getPolicyId() {
        return policyId;
    }

    public int getPolicyHolderId() {
        return policyHolderId;
    }

    public String getPolicyType() {
        return policyType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

}
