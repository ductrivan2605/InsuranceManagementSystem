//package com.insurancemanagementsystem.controller;
//
//import com.insurancemanagementsystem.model.Policy;
//import com.insurancemanagementsystem.model.PolicyType;
//import com.insurancemanagementsystem.service.PolicyService;
//import com.insurancemanagementsystem.service.PolicyServiceImpl;
//import javafx.fxml.FXML;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.Date;
//
//public class AddPolicyController {
//
//    @FXML
//    private TextField policyNumberField;
//
//    @FXML
//    private DatePicker startDatePicker;
//
//    @FXML
//    private DatePicker endDatePicker;
//
//    @FXML
//    private TextField typeField;
//
//    @FXML
//    private TextField coverageAmountField;
//
//    @FXML
//    private TextField userIdField;
//
//    private PolicyService policyService = new PolicyServiceImpl();
//
//    @FXML
//    private void handleAddPolicy() {
//        String policyNumber = policyNumberField.getText();
//        LocalDate startDate = startDatePicker.getValue();
//        LocalDate endDate = endDatePicker.getValue();
//        String type = typeField.getText();
//        double coverageAmount = Double.parseDouble(coverageAmountField.getText());
//        String userId = userIdField.getText();
//
//        Date startDateConverted = Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
//        Date endDateConverted = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
//
//        Policy newPolicy = new Policy(policyNumber, userId, PolicyType.valueOf(type.toUpperCase()), startDateConverted, endDateConverted, coverageAmount);
//        policyService.createPolicy(newPolicy);
//
//        // Close the form after adding the policy
//        Stage stage = (Stage) policyNumberField.getScene().getWindow();
//        stage.close();
//    }
//}
