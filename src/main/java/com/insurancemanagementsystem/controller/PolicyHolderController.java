package com.insurancemanagementsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class PolicyHolderController {

    @FXML
    private VBox claimsDashboard;

    @FXML
    private VBox editClaims;

    @FXML
    private VBox personalInfo;

    @FXML
    private Label placeholderLabel;

    @FXML
    private TableView<?> dataTableView;

    @FXML
    private void initialize() {
        // Initial setup if necessary
    }

    @FXML
    private void showClaimsDashboard() {
        claimsDashboard.setVisible(true);
        editClaims.setVisible(false);
        personalInfo.setVisible(false);
        placeholderLabel.setVisible(false);
        dataTableView.setVisible(false);
    }

    @FXML
    private void showEditClaims() {
        claimsDashboard.setVisible(false);
        editClaims.setVisible(true);
        personalInfo.setVisible(false);
        placeholderLabel.setVisible(false);
        dataTableView.setVisible(false);
    }

    @FXML
    private void showPersonalInfo() {
        claimsDashboard.setVisible(false);
        editClaims.setVisible(false);
        personalInfo.setVisible(true);
        placeholderLabel.setVisible(false);
        dataTableView.setVisible(false);
    }
}
