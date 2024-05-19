package com.insurancemanagementsystem.model;

import java.util.Date;

public class Policy {

    private String policyId;
    private String policyHolderId;
    private PolicyType policyType;
    private Date startDate;
    private Date endDate;


    public Policy(String policyId, String policyHolderId, PolicyType policyType, Date startDate, Date endDate) {
        this.policyId = policyId;
        this.policyHolderId = policyHolderId;
        this.policyType = policyType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getPolicyHolderId() {
        return policyHolderId;
    }

    public PolicyType getPolicyType() {
        return policyType;
    }
    public void setPolicyType(PolicyType policyType) {
        this.policyType = policyType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

}
