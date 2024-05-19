package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.MainApp;
import com.insurancemanagementsystem.model.Policy;
import com.insurancemanagementsystem.model.PolicyType;
import com.insurancemanagementsystem.model.Role;
import com.insurancemanagementsystem.model.User;
import com.insurancemanagementsystem.util.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SystemAdminPolicyController implements Initializable {
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    private MainApp mainApp;
    private User user;

    public void setUser(User user) {
        this.user = user;
    }
    @FXML
    private TableView<Policy> policyTableView;
    @FXML
    private TableColumn<Policy, String> policyIDTableColumn;
    @FXML
    private TableColumn<Policy, Date> startDateTableColumn;
    @FXML
    private TableColumn<Policy, Date> endDateTableColumn;
    @FXML
    private TableColumn<Policy, PolicyType> policyTypeTableColumn;
    @FXML
    private TableColumn<Policy, String> policyHolderTableColumn;

    ObservableList<Policy> policySearchObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String userViewQuery = "SELECT * FROM policies";
        try {
            Connection connectDB = DatabaseConnection.getConnection();
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(userViewQuery);

            while (queryOutput.next()) {
                String queryPolicyID = queryOutput.getString("policy_number");
                Date queryStartDate = queryOutput.getDate("start_date");
                Date queryEndDate = queryOutput.getDate("end_date");
                String typeString = queryOutput.getString("type").toUpperCase();
                PolicyType queryPolicyType;
                try {
                    queryPolicyType = PolicyType.valueOf(typeString);
                } catch (IllegalArgumentException e) {
                    // Handle the error here, e.g., by logging an error message or setting queryPolicyType to a default value
                    System.err.println("Invalid PolicyType value: " + typeString);
                    queryPolicyType = PolicyType.HEALTH; // Set to a default value or handle the error in another way
                }
                String queryPolicyHolder = queryOutput.getString("id");
                policySearchObservableList.add(new Policy(queryPolicyID, queryPolicyHolder, queryPolicyType, queryStartDate, queryEndDate));
            }
            policyIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("policyId"));
            startDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
            endDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
            policyTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("policyType"));
            policyHolderTableColumn.setCellValueFactory(new PropertyValueFactory<>("policyHolderId"));

            policyTableView.setItems(policySearchObservableList);
        } catch (Exception e) {
            Logger.getLogger(SystemAdminUserController.class.getName()).log(Level.SEVERE, null, e);
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
}
