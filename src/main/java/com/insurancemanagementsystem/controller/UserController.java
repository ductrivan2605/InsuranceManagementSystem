package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.service.UserService;
import com.insurancemanagementsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Assuming Spring MVC


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import com.insurancemanagementsystem.model.User;

public class UserController {
// code due to the database
    @FXML private ComboBox<String> filterComboBox;
    @FXML private TextField searchTextField;
    @FXML private TableView<User> adminTableView;
    @FXML private TableColumn<User, Integer> user_id;
    @FXML private TableColumn<User, String> first_name;
    @FXML private TableColumn<User, String> last_name;
    @FXML private TableColumn<User, String> email;
    @FXML private TableColumn<User, String> password;
    @FXML private TableColumn<User, String> role;
    @FXML private Button addUserButton;
    @FXML private Button updateUserButton;
    @FXML private Button deleteUserButton;

    private ObservableList<User> users = FXCollections.observableArrayList();

    public void initialize() {
        filterComboBox.setItems(FXCollections.observableArrayList("All", "Admin", "Provider", "Customer"));
        adminTableView.setItems(users);

        user_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        first_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        last_name.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));

        // Add event listeners and other initialization code
    }

    @FXML
    private void handleAddUser() {
        // Code to add a new user
    }

    @FXML
    private void handleUpdateUser() {
        // Code to update an existing user
    }

    @FXML
    private void handleDeleteUser() {
        // Code to delete a user
    }

    @FXML
    private void applyFilter() {
        // Code to filter the user list based on the selected filter and search text
    }
}
