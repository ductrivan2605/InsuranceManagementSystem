package com.insurancemanagementsystem.model;

import java.util.Date;

public class Policy {
    private String policyId;
    private String policyHolderId;
    private PolicyType policyType;
    private Date startDate;
    private Date endDate;
    private double coverageAmount;

    public Policy(String policyId, String policyHolderId, PolicyType policyType, Date startDate, Date endDate, double coverageAmount) {
        this.policyId = policyId;
        this.policyHolderId = policyHolderId;
        this.policyType = policyType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coverageAmount = coverageAmount;
    }

    public Policy(String policyIdValue, String policyHolderId, PolicyType policyType, java.sql.Date startDate, java.sql.Date endDate) {
    }

    public String getPolicyId() { return policyId; }
    public String getPolicyHolderId() { return policyHolderId; }
    public PolicyType getPolicyType() { return policyType; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public double getCoverageAmount() { return coverageAmount; }
}
