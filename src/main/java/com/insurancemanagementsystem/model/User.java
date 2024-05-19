package com.insurancemanagementsystem.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String fullName;
    private Role role;
    private String email;
    private String phoneNumber; // Add phoneNumber field

    // Constructor without ID, for creating new users
    public User(String username, String password, String fullName, Role role, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.email = email;
        this.phoneNumber = phoneNumber; // Initialize phoneNumber
    }

    // Constructor with ID, for retrieving users from the database
    public User(int id, String username, String password, String fullName, Role role, String email, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.email = email;
        this.phoneNumber = phoneNumber; // Initialize phoneNumber
    }

    // Getters and Setters
    public int getUserId() {
        return id;
    }

    public void setUserId(String userId) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAdmin() {
        return role == Role.SYSTEM_ADMIN;
    }

    public boolean isManager() {
        return role == Role.INSURANCE_MANAGER;
    }

    public boolean isSurveyor() {
        return role == Role.INSURANCE_SURVEYOR;
    }

    public boolean isPolicyOwner() {
        return role == Role.POLICY_OWNER;
    }

    public boolean isPolicyHolder() {
        return role == Role.POLICY_HOLDER;
    }

    public boolean isDependent() {
        return role == Role.DEPENDENT;
    }
}
