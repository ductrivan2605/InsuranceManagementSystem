package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.MainApp;
import com.insurancemanagementsystem.model.Claim;
import com.insurancemanagementsystem.model.ClaimStatus;
import com.insurancemanagementsystem.model.Policy;
import com.insurancemanagementsystem.model.User;
import com.insurancemanagementsystem.service.ClaimService;
import com.insurancemanagementsystem.service.ClaimServiceImpl;
import com.insurancemanagementsystem.util.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SystemAdminClaimController implements Initializable {
    private ClaimService claimService = new ClaimServiceImpl();
    private final ObservableList<Claim> claimSearchObservableList = FXCollections.observableArrayList();

    @FXML
    private TableView<Claim> claimTableView;
    @FXML
    private TableColumn<Claim, String> claimIDTableColumn;
    @FXML
    private TableColumn<Claim, String> claimDateTableColumn;
    @FXML
    private TableColumn<Claim, String> policyHolderIDTableColumn;
    @FXML
    private TableColumn<Claim, String> cardNumberTableColumn;
    @FXML
    private TableColumn<Claim, String> examDateTableColumn;
    @FXML
    private TableColumn<Claim, String> policyIDTableColumn;
    @FXML
    private TableColumn<Claim, Double> claimAmountTableColumn;
    @FXML
    private TableColumn<Claim, String> statusTableColumn;
    @FXML
    private TableColumn<Claim, String> receiverBankTableColumn;
    @FXML
    private TableColumn<Claim, String> receiverNameTableColumn;
    @FXML
    private TableColumn<Claim, String> receiverNumberTableColumn;
    @FXML
    private TextField keywordTextField;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    private MainApp mainApp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String claimViewQuery = "SELECT * FROM claims";
        try {
            Connection connectDB = DatabaseConnection.getConnection();
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(claimViewQuery);

            while (queryOutput.next()) {
                int queryClaimID = queryOutput.getInt("claim_id");
                Date queryClaimDate = queryOutput.getDate("claim_date");
                User queryPolicyHolderID = ClaimServiceImpl.getPolicyHolder(queryOutput.getInt("policy_holder_id"));
                String queryCardNumber = queryOutput.getString("card_number");
                Date queryExamDate = queryOutput.getDate("exam_date");
                Policy queryPolicyID = ClaimServiceImpl.getPolicy(queryOutput.getString("policy_number"));
                double queryClaimAmount = queryOutput.getDouble("claim_amount");
                ClaimStatus queryStatus = ClaimStatus.valueOf(queryOutput.getString("status"));
                String queryReceiverBank = queryOutput.getString("receiver_bank");
                String queryReceiverName = queryOutput.getString("receiver_name");
                String queryReceiverNumber = queryOutput.getString("receiver_number");

                claimSearchObservableList.add(new Claim(queryClaimID, queryClaimDate, queryPolicyHolderID, queryCardNumber, queryExamDate, queryPolicyID, queryClaimAmount, queryStatus, queryReceiverBank, queryReceiverName, queryReceiverNumber));
            }

            claimIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("claim_id"));
            claimDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("claimDate"));
            policyHolderIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("policyHolderId"));
            cardNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("cardNumber"));
            examDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("examDate"));
            policyIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("policyID"));
            claimAmountTableColumn.setCellValueFactory(new PropertyValueFactory<>("claimAmount"));
            statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
            receiverBankTableColumn.setCellValueFactory(new PropertyValueFactory<>("receiverBank"));
            receiverNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("receiverName"));
            receiverNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("receiverNumber"));

            claimTableView.setItems(claimSearchObservableList);

            FilteredList<Claim> filteredData = new FilteredList<>(claimSearchObservableList, b -> true);

            keywordTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(claim -> {
                    if (newValue.isEmpty() && newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (claim.getClaimDate().toString().contains(searchKeyword)) {
                        return true;
                    } else if (claim.getPolicyHolder().toString().toLowerCase().contains(searchKeyword)) {
                        return true;
                    } else if (claim.getCardNumber().toLowerCase().contains(searchKeyword)) {
                        return true;
                    } else if (claim.getExamDate().toString().contains(searchKeyword)) {
                        return true;
                    } else if (claim.getPolicyId().toString().toLowerCase().contains(searchKeyword)) {
                        return true;
                    } else if (String.valueOf(claim.getClaimAmount()).contains(searchKeyword)) {
                        return true;
                    } else if (claim.getStatus().toString().toLowerCase().contains(searchKeyword)) {
                        return true;
                    } else if (claim.getReceiverBank().toLowerCase().contains(searchKeyword)) {
                        return true;
                    } else if (claim.getReceiverName().toLowerCase().contains(searchKeyword)) {
                        return true;
                    } else if (claim.getReceiverNumber().toLowerCase().contains(searchKeyword)) {
                        return true;
                    } else {
                        return false;
                    }
                });
            });

            SortedList<Claim> sortedData = new SortedList<>(filteredData);

            sortedData.comparatorProperty().bind(claimTableView.comparatorProperty());

            enableCellEditing();
        } catch (Exception e) {
            Logger.getLogger(SystemAdminClaimController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSwapToClaimDB() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/TheSystemAdmin_ClaimView.fxml"));
            AnchorPane claimDBRoot = loader.load();
            Scene scene = new Scene(claimDBRoot);
            mainApp.getPrimaryStage().setScene(scene);
            mainApp.getPrimaryStage().setTitle("Insurance Management System - Admin Dashboard -Claim");
            mainApp.getPrimaryStage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleSwapToUserDB() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/TheSystemAdmin_User.fxml"));
            AnchorPane userDBRoot = loader.load();
            Scene scene = new Scene(userDBRoot);
            mainApp.getPrimaryStage().setScene(scene);
            mainApp.getPrimaryStage().setTitle("Insurance Management System - Admin Dashboard - User");
            mainApp.getPrimaryStage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleSwapToPolicyDB() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/TheSystemAdmin_PolicyView.fxml"));
            AnchorPane policyDBRoot = loader.load();
            Scene scene = new Scene(policyDBRoot);
            mainApp.getPrimaryStage().setScene(scene);
            mainApp.getPrimaryStage().setTitle("Insurance Management System - Admin Dashboard - Policy");
            mainApp.getPrimaryStage().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleDelete() throws Exception {
        // Get the selected claim from the table
        Claim selectedClaim = claimTableView.getSelectionModel().getSelectedItem();
        if (selectedClaim != null) {
            // Remove the selected claim from the list
            claimSearchObservableList.remove(selectedClaim);

            claimService.deleteClaim(selectedClaim.getId());
        } else {
            System.out.println("No claim selected");
        }
    }
    private void enableCellEditing() {
        claimTableView.setEditable(true);
        claimTableView.getSelectionModel().setCellSelectionEnabled(true);
    }

}