package com.insurancemanagementsystem.model;

import javafx.beans.property.*;
public class User {
    private String userId;
    private String username;
    private String password;
    private String fullName;
    private Role role;
    private String userEmail;
    private int phoneNumber;

    public User(String userId, String username, String password, String fullName,Role role, String userEmail,int phoneNumber) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {return userId;
    }
    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return userEmail;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAdmin(){
        return role.contains(Role.SYSTEM_ADMIN);
    }
    public boolean isManager(){
        return role.contains(Role.INSURANCE_MANAGER);
    }
    public boolean isSurveyor(){
        return role.contains(Role.INSURANCE_SURVEYOR);
    }
    public boolean isPolicyOwner(){
        return role.contains(Role.POLICY_OWNER);
    }
    public boolean isPolicyHolder(){
        return role.contains(Role.POLICY_HOLDER);
    }
    public boolean isDependent(){
        return role.contains(Role.DEPENDENT);
    }

    public String getUsername() {
        return username;
    }
}

