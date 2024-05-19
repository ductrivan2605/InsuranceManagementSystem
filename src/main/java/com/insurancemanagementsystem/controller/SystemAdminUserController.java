package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.MainApp;
import com.insurancemanagementsystem.model.Role;
import com.insurancemanagementsystem.util.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import com.insurancemanagementsystem.model.User;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
                int queryUserPhoneNumber = queryOutput.getInt("phone_number");
            //    userSearchObservableList.add(new User(queryUserID, queryUserName, queryUserPassword,queryFullName,queryUserRole,queryUserEmail, queryUserPhoneNumber));
            }
            userIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            userNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
            passWordTableColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
            fullNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("full_name"));
            roleTableColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
            userEmailTableColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            userPhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phone_number"));

            userTableView.setItems(userSearchObservableList);
        } catch (Exception e) {
            Logger.getLogger(SystemAdminUserController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }
}