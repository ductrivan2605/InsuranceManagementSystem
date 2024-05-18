package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.MainApp;
import com.insurancemanagementsystem.model.Role;
import com.insurancemanagementsystem.service.UserServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SignInController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private MainApp mainApp;
    private UserServiceImpl userService;

    public SignInController() {
        userService = new UserServiceImpl();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleSignInButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            Role role = userService.authenticateUser(username, password);
            if (role != null) {
                mainApp.showViewBasedOnRole(role.toString());
            } else {
                showAlert("Sign In Failed", "Invalid username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Sign In Failed", "An error occurred. Please try again.");
        }
    }

    @FXML
    private void handleSignUpButtonAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/SignUp.fxml"));
            GridPane signUpRoot = loader.load();
            Scene scene = new Scene(signUpRoot);
            mainApp.getPrimaryStage().setScene(scene);
            mainApp.getPrimaryStage().setTitle("Insurance Management System - Sign Up");
            mainApp.getPrimaryStage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
