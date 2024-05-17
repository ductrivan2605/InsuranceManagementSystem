package com.insurancemanagementsystem.controller;

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

    @FXML
    private void handleSignUpButtonAction() {
        String fullName = fullNameField.getText();
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (password.equals(confirmPassword)) {
            // Replace this with your actual sign-up logic
            signUpMessageLabel.setText("Sign-up successful!");
            signUpMessageLabel.setStyle("-fx-text-fill: green;");
        } else {
            signUpMessageLabel.setText("Passwords do not match.");
            signUpMessageLabel.setStyle("-fx-text-fill: red;");
        }
    }
}
