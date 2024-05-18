//package com.insurancemanagementsystem.controller;
//
//import com.insurancemanagementsystem.model.Role;
//import com.insurancemanagementsystem.model.User;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class SystemAdminPolicyController implements Initializable {
//    private User user;
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//    @FXML
//    private TableView<User> userTableView;
//    @FXML
//    private TableColumn<User, String> userIDTableColumn;
//    @FXML
//    private TableColumn<User, String> userNameTableColumn;
//    @FXML
//    private TableColumn<User, String> passWordTableColumn;
//    @FXML
//    private TableColumn<User, String> fullNameTableColumn;
//    @FXML
//    private TableColumn<User, Role> roleTableColumn;
//    @FXML
//    private TableColumn<User, String> userEmailTableColumn;
//
//    ObservableList<User> userSearchObservableList = FXCollections.observableArrayList();
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//    }
//}