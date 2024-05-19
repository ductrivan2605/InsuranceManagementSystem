package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.MainApp;
import com.insurancemanagementsystem.model.Role;
import com.insurancemanagementsystem.util.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import com.insurancemanagementsystem.model.User;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SystemAdminUserController implements Initializable {
    private User user;
    private MainApp mainApp;

    public void setUser(User user) {
        this.user = user;
    }
    @FXML
    private TableView<User> userTableView;
    @FXML
    private TableColumn<User, String> userIDTableColumn;
    @FXML
    private TableColumn<User, String> userNameTableColumn;
    @FXML
    private TableColumn<User, String> passWordTableColumn;
    @FXML
    private TableColumn<User, String> fullNameTableColumn;
    @FXML
    private TableColumn<User, Role> roleTableColumn;
    @FXML
    private TableColumn<User, String> userEmailTableColumn;
    @FXML
    private TableColumn<User, Integer> userPhoneNumberColumn;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    ObservableList<User> userSearchObservableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String userViewQuery = "SELECT * FROM users";
        try {
            Connection connectDB = DatabaseConnection.getConnection();
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(userViewQuery);

            while (queryOutput.next()) {
                String queryUserID = queryOutput.getString("id");
                String queryUserName = queryOutput.getString("username");
                String queryUserPassword = queryOutput.getString("password");
                String queryFullName = queryOutput.getString("full_name");
                Role queryUserRole = Role.valueOf(queryOutput.getString("role"));
                String queryUserEmail = queryOutput.getString("email");
                String queryUserPhoneNumber = queryOutput.getString("phone_number");
                userSearchObservableList.add(new User(queryUserID, queryUserName, queryUserPassword,queryFullName,queryUserRole,queryUserEmail, queryUserPhoneNumber));
            }
            userIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            userNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
            passWordTableColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
            fullNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
            roleTableColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
            userEmailTableColumn.setCellValueFactory(new PropertyValueFactory<>("userEmail"));
            userPhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

            userTableView.setItems(userSearchObservableList);
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