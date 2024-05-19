package com.insurancemanagementsystem.model;

public class User {
    private String userId;
    private String username;
    private String password;
    private String fullName;
    private Role role;
    private String email;

    // Constructor without ID, for creating new users
    public User(String username, String password, String fullName, Role role, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.email = email;
    }

    // Constructor with ID, for retrieving users from the database
    public User(String userId, String username, String password, String fullName, Role role, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.email = email;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

//    public int getPhoneNumber() {
//    }
}


// code due to the database

//public class User {
//    private final IntegerProperty id;
//    private final StringProperty firstName;
//    private final StringProperty lastName;
//    private final StringProperty email;
//    private final StringProperty password;
//    private final StringProperty role;
//
//    public User(int id, String firstName, String lastName, String email, String password, String role) {
//        this.id = new SimpleIntegerProperty(id);
//        this.firstName = new SimpleStringProperty(firstName);
//        this.lastName = new SimpleStringProperty(lastName);
//        this.email = new SimpleStringProperty(email);
//        this.password = new SimpleStringProperty(password);
//        this.role = new SimpleStringProperty(role);
//    }
//
//    public int getId() {
//        return id.get();
//    }
//
//    public void setId(int id) {
//        this.id.set(id);
//    }
//
//    public IntegerProperty idProperty() {
//        return id;
//    }
//
//    public String getFirstName() {
//        return firstName.get();
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName.set(firstName);
//    }
//
//    public StringProperty firstNameProperty() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName.get();
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName.set(lastName);
//    }
//
//    public StringProperty lastNameProperty() {
//        return lastName;
//    }
//
//    public String getEmail() {
//        return email.get();
//    }
//
//    public void setEmail(String email) {
//        this.email.set(email);
//    }
//
//    public StringProperty emailProperty() {
//        return email;
//    }
//
//    public String getPassword() {
//        return password.get();
//    }
//
//    public void setPassword(String password) {
//        this.password.set(password);
//    }
//
//    public StringProperty passwordProperty() {
//        return password;
//    }
//
//    public String getRole() {
//        return role.get();
//    }
//
//    public void setRole(String role) {
//        this.role.set(role);
//    }
//
//    public StringProperty roleProperty() {
//        return role;
//    }
//}
