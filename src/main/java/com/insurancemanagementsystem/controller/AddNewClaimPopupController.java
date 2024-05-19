package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.model.*;
import com.insurancemanagementsystem.service.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class AddNewClaimPopupController {

    @FXML
    private TextField claimDateTextField;

    @FXML
    private TextField policyHolderTextField;

    @FXML
    private TextField cardNumberTextField;

    @FXML
    private TextField examDateTextField;

    @FXML
    private TextField policyTextField;

    @FXML
    private TextField claimAmountTextField;

    @FXML
    private TextField statusTextField;

    @FXML
    private TextField receiverBankTextField;

    @FXML
    private TextField receiverNameTextField;

    @FXML
    private TextField receiverNumberTextField;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    private ClaimService claimService = new ClaimServiceImpl();
    private UserService userService = new UserServiceImpl();
    private PolicyService policyService = new PolicyServiceImpl();

    // Initialize method to set default values if needed
    @FXML
    private void initialize() {
        // You can add default initialization code here if needed
    }

    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        try {
            // Retrieve values from the text fields
            String claimDateStr = claimDateTextField.getText();
            String policyHolderId = policyHolderTextField.getText();
            String cardNumber = cardNumberTextField.getText();
            String examDateStr = examDateTextField.getText();
            String policyIdStr = policyTextField.getText();
            double claimAmount = Double.parseDouble(claimAmountTextField.getText());
            String statusStr = statusTextField.getText();
            String receiverBank = receiverBankTextField.getText();
            String receiverName = receiverNameTextField.getText();
            String receiverNumber = receiverNumberTextField.getText();

            // Convert date strings to Date objects
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date claimDate = dateFormat.parse(claimDateStr);
            Date examDate = dateFormat.parse(examDateStr);

            // Retrieve User and Policy objects from the services
            Optional<User> optionalPolicyHolder = userService.getUserById(policyHolderId);
            Optional<Policy> optionalPolicy = Optional.ofNullable(policyService.getPolicyById(policyIdStr));

            if (optionalPolicyHolder.isEmpty() || optionalPolicy.isEmpty()) {
                throw new IllegalArgumentException("Invalid policy holder ID or policy ID");
            }

            User policyHolder = optionalPolicyHolder.get();
            Policy policy = optionalPolicy.get();

            // Create a new Claim object
            ClaimStatus status = ClaimStatus.valueOf(statusStr.toUpperCase());
            Claim claim = new Claim(null, claimDate, policyHolder, cardNumber, examDate, policy, claimAmount, status, receiverBank, receiverName, receiverNumber);

            // Save the claim using the service
            claimService.createClaim(claim);

            // Close the window after saving
            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.close();

        } catch (ParseException e) {
            // Handle the exception for date parsing
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // Handle the exception for number parsing
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // Handle invalid user or policy ID
            e.printStackTrace();
        } catch (Exception e) {
            // Handle any other exceptions
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
        // Close the window without saving
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
