package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.model.Role;
import com.insurancemanagementsystem.model.User;
import com.insurancemanagementsystem.service.UserService;
import com.insurancemanagementsystem.service.UserServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label signUpMessageLabel;

    private final UserService userService = new UserServiceImpl();

    @FXML
    private void handleSignUpButtonAction() {
        String fullName = fullNameField.getText();
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (password.equals(confirmPassword)) {
            try {
                User user = new User(null, username, password, fullName, Role.USER, email, "000000000"); // Add a phone number or get it from input

                userService.createUser(user);
                signUpMessageLabel.setText("Sign-up successful!");
                signUpMessageLabel.setStyle("-fx-text-fill: green;");
            } catch (Exception e) {
                e.printStackTrace();
                signUpMessageLabel.setText("Sign-up failed.");
                signUpMessageLabel.setStyle("-fx-text-fill: red;");
            }
        } else {
            signUpMessageLabel.setText("Passwords do not match.");
            signUpMessageLabel.setStyle("-fx-text-fill: red;");
        }
    }
}
