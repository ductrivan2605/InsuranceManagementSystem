package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignInController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleSignInButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (validateSignIn(username, password)) {
            // Fetch user role from database and show appropriate view
            String role = getUserRole(username, password);
            if (role != null) {
                mainApp.showViewBasedOnRole(role);
            } else {
                showAlert("Sign In Failed", "Invalid username or password.");
            }
        } else {
            showAlert("Sign In Failed", "Invalid username or password.");
        }
    }

    private boolean validateSignIn(String username, String password) {
        // Implement database validation here
        return getUserRole(username, password) != null;
    }

    private String getUserRole(String username, String password) {
        String role = null;
        try (Connection conn = DriverManager.getConnection("postgresql://claiminsurancesystem_owner:pSFcMzs4X7Kk@ep-old-frost-a1v0y414.ap-southeast-1.aws.neon.tech/claiminsurancesystem?sslmode=require")) {
            String sql = "SELECT role FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                role = rs.getString("role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
}
