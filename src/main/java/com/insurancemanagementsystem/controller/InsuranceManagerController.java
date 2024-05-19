package com.insurancemanagementsystem.controller;


import com.insurancemanagementsystem.service.*;
import com.insurancemanagementsystem.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.insurancemanagementsystem.model.Claim;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import java.util.List;

@RestController
@RequestMapping("/api/insurance-managers")


public class InsuranceManagerController {
    private User user;
    public void setUser(User user) {
        this.user = user;
    }

    @FXML
    private TableView<Claim> claimsTable;

    @FXML
    private TableColumn<Claim, String> claimIdColumn;

    @FXML
    private TableColumn<Claim, String> policyNumberColumn;

    @FXML
    private TableColumn<Claim, String> dateFiledColumn;

    @FXML
    private TableColumn<Claim, String> descriptionColumn;

    @FXML
    private TableColumn<Claim, String> statusColumn;

    @FXML
    private TableColumn<Claim, String> amountClaimedColumn;

    @FXML
    private TableColumn<Claim, String> surveyorIdColumn;

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    private RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://localhost:8080/api/insurance-surveyors";

    @Autowired
    private ClaimService claimService;

    @FXML
    public void initialize() {
        claimIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        policyNumberColumn.setCellValueFactory(new PropertyValueFactory<>("policyNumber"));
        dateFiledColumn.setCellValueFactory(new PropertyValueFactory<>("claimDate"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        amountClaimedColumn.setCellValueFactory(new PropertyValueFactory<>("claimAmount"));
        surveyorIdColumn.setCellValueFactory(new PropertyValueFactory<>("surveyorId"));

        loadClaims();
    }

    private void loadClaims() {
        List<Claim> claims = restTemplate.getForObject(BASE_URL + "/claims", List.class);
        claimsTable.getItems().setAll(claims);
    }

    @FXML
    private void handleSearch() {
        String filter = searchField.getText();
        List<Claim> filteredClaims = restTemplate.getForObject(BASE_URL + "/claims/" + filter, List.class);
        claimsTable.getItems().setAll(filteredClaims);
    }
}