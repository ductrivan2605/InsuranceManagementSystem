package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.model.Claim;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class PolicyHolderController {
    @FXML
    private TableView<Claim> claimTableView;

    @FXML
    private TableColumn<Claim, String> claimsDashboard;

    @FXML
    private TableColumn<Claim, String> editClaims;

    @FXML
    private TableColumn<Claim, String> personalInfo;

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
