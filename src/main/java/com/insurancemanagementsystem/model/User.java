package com.insurancemanagementsystem.model;

public abstract class User {
    private String userId;
    private String username;
    private String password;
    private String fullName;
    private Role role;
    private String userEmail;

    public User(String userId, String username, String password, String fullName,Role role, String userEmail) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }
    public String getFullName() {
        return fullName;
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

    public abstract String getUserType();

    public Role getRole() {
        return role;
    }
}
