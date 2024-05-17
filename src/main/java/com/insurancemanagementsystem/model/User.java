package com.insurancemanagementsystem.model;

import javafx.beans.property.*;
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

// code due to the database

public class User {
    private final IntegerProperty id;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty email;
    private final StringProperty password;
    private final StringProperty role;

    public User(int id, String firstName, String lastName, String email, String password, String role) {
        this.id = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.role = new SimpleStringProperty(role);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getRole() {
        return role.get();
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    public StringProperty roleProperty() {
        return role;
    }
}
