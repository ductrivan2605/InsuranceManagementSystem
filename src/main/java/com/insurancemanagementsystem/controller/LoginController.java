package com.insurancemanagementsystem.controller;

import com.insurancemanagementsystem.model.Role;
import com.insurancemanagementsystem.model.User;
//import com.insurancemanagementsystem.repository.UserRepository;
import com.insurancemanagementsystem.service.UserService;
import com.insurancemanagementsystem.service.UserServiceImpl;
import com.insurancemanagementsystem.util.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;


import java.io.IOException;


public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginMessageLabel;

    // Ensure a public no-argument constructor is present
    public LoginController() {
    }

    @FXML
    private void handleLoginButtonAction() {
        // Logic to handle login action
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Placeholder logic to update login message
        if ("admin".equals(username) && "admin".equals(password)) {
            loginMessageLabel.setText("Login successful!");
        } else {
            loginMessageLabel.setText("Login failed.");
        }
    }
}

//public class LoginController {
////    private User user;
////    private final Stage primaryStage;
//// //   private UserRepository userRepository;
////    private final UserService userService = new UserServiceImpl();
////
////    public LoginController(Stage primaryStage) {
////        this.primaryStage = primaryStage;
////    }
////
////    public void setUser(User user) {
////        this.user = user;
////    }
////    @FXML
////    private void handleLoginButtonAction(ActionEvent event) throws Exception {
////        // authenticate the user
////        //User user = authenticateUser();
////        // after successful login, display the appropriate scene based on the user's role
////        if (user.isAdmin()) {
////            loadScene("PolicyHolderScene.fxml", "Policy Holder");
////        } else if (user.getRole().equals("DEPENDENT")) {
////            loadScene("DependentScene.fxml", "Policy Holder");
////        } else if (user.getRole().equals("POLICY_OWNER")) {
////            loadScene("PolicyOwnerScene.fxml", "Policy Holder");
////        } else if (user.getRole().equals("INSURANCE_SURVEYOR")) {
////            loadScene("InsuranceSurveyorScene.fxml", "Policy Holder");
////        } else if (user.getRole().equals("INSURANCE_MANAGER")) {
////            loadScene("InsuranceManagerScene.fxml", "Policy Holder");
////        } else if (user.getRole().equals("SYSTEM_ADMIN")) {
////            loadScene("SystemAdminScene.fxml", "Policy Holder");
////        } else {
////            // display an error message for unsupported roles
////            displayErrorMessage("Unsupported user role. Please contact support.");
////        }
//    }

//    private User authenticateUser() throws Exception {
//        // get the user's username and password from the UI
//        String username = usernameField.getText();
//        String password = passwordField.getText();
//
//        // validate the user's credentials
//        Role user = userService.authenticateUser(username, password);
//
//        if (user == null) {
//            // display an error message if the user's credentials are invalid
//            displayErrorMessage("Invalid username or password. Please try again.");
//        }
//
//        return user;
//    }
//
//    private void loadScene(String fxmlFile, String title) {
//        try {
//            // load the fxml file
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
//            Parent root = loader.load();
//
//            // get the controller for the loaded fxml file
//            Object controller = loader.getController();
//
//            // cast the controller to the appropriate custom controller class
//            if (fxmlFile.equals("PolicyHolderScene.fxml")) {
//                PolicyHolderController policyHolderController = (PolicyHolderController) controller;
//                policyHolderController.setUser(user);
//            } else if (fxmlFile.equals("DependentScene.fxml")) {
//                DependentController dependentController = (DependentController) controller;
//                dependentController.setUser(user);
//            } else if (fxmlFile.equals("PolicyOwnerScene.fxml")) {
//                PolicyOwnerController policyOwnerController = (PolicyOwnerController) controller;
//                policyOwnerController.setUser(user);
//            } else if (fxmlFile.equals("InsuranceSurveyorScene.fxml")) {
//                InsuranceSurveyorController insuranceSurveyorController = (InsuranceSurveyorController) controller;
//                insuranceSurveyorController.setUser(user);
//            } else if (fxmlFile.equals("InsuranceManagerScene.fxml")) {
//                InsuranceManagerController insuranceManagerController = (InsuranceManagerController) controller;
//                insuranceManagerController.setUser(user);
//            } else if (fxmlFile.equals("SystemAdminScene.fxml")) {
//                SystemAdminController systemAdminController = (SystemAdminController) controller;
//                systemAdminController.setUser(user);
//            }
//
//            // create a new scene with the loaded root and title
//            Scene scene = new Scene(root);
//
//            // set the new scene for the primary stage
//            primaryStage.setScene(scene);
//
//            // set the primary stage title
//            primaryStage.setTitle(title);
//
//            // show the primary stage
//            primaryStage.show();
//        } catch (IOException e) {
//            // handle the exception
//            displayErrorMessage("Failed to load the scene. Please contact support.");
//        }
//    }
//    @FXML private TextField usernameField;
//    @FXML private PasswordField passwordField;
//    private void displayErrorMessage(String s) {
//    }
//}
