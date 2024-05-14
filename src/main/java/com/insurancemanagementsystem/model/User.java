package com.insurancemanagementsystem.model;

public class User {
    private Long userId;
    private String username;
    private String password;
    private String fullName;
    private Role role;
    private String userEmail;

    public User(Long userId, String username, String password, String fullName,Role role, String userEmail) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.userEmail = userEmail;
    }

    public Long getUserId() {
        return userId;
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
