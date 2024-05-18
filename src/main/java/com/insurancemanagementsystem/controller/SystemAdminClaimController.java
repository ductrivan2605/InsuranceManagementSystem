package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.MainApp;
import com.insurancemanagementsystem.model.Claim;
import com.insurancemanagementsystem.model.ClaimStatus;
import com.insurancemanagementsystem.model.Policy;
import com.insurancemanagementsystem.model.User;
import com.insurancemanagementsystem.service.ClaimServiceImpl;
import com.insurancemanagementsystem.util.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SystemAdminClaimController implements Initializable {
    private ObservableList<Claim> claimSearchObservableList = FXCollections.observableArrayList();

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
                String queryClaimID = queryOutput.getString("id");
                Date queryClaimDate = queryOutput.getDate("claim_date");
                User queryPolicyHolderID = ClaimServiceImpl.getPolicyHolder(queryOutput.getInt("policy_holder_id"));
                String queryCardNumber = queryOutput.getString("card_number");
                Date queryExamDate = queryOutput.getDate("exam_date");
                Policy queryPolicyID = ClaimServiceImpl.getPolicy(queryOutput.getInt("policy_id"));
                double queryClaimAmount = queryOutput.getDouble("claim_amount");
                ClaimStatus queryStatus = ClaimStatus.valueOf(queryOutput.getString("claim_status"));
                String queryReceiverBank = queryOutput.getString("receiver_bank");
                String queryReceiverName = queryOutput.getString("receiver_name");
                String queryReceiverNumber = queryOutput.getString("receiver_number");

                claimSearchObservableList.add(new Claim(queryClaimID, queryClaimDate, queryPolicyHolderID, queryCardNumber, queryExamDate, queryPolicyID, queryClaimAmount, queryStatus, queryReceiverBank, queryReceiverName, queryReceiverNumber));
            }

            claimIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            claimDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("claimDate"));
            policyHolderIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("policyHolderID"));
            cardNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("cardNumber"));
            examDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("examDate"));
            policyIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("policyID"));
            claimAmountTableColumn.setCellValueFactory(new PropertyValueFactory<>("claimAmount"));
            statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
            receiverBankTableColumn.setCellValueFactory(new PropertyValueFactory<>("receiverBank"));
            receiverNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("receiverName"));
            receiverNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("receiverNumber"));

            claimTableView.setItems(claimSearchObservableList);
        } catch (Exception e) {
            Logger.getLogger(SystemAdminClaimController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }
}