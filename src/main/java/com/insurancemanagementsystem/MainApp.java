package com.insurancemanagementsystem;

import com.insurancemanagementsystem.controller.SignInController;
import com.insurancemanagementsystem.controller.SystemAdminClaimController;
import com.insurancemanagementsystem.controller.SystemAdminUserController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Insurance Management System");

        showSignInView();
    }

    public void showSignInView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/TheSystemAdmin_ClaimView.fxml"));
            Pane signInLayout = loader.load();

            SystemAdminClaimController controller = loader.getController();
            controller.setMainApp(this);

            Scene scene = new Scene(signInLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showViewBasedOnRole(String role) {
        try {
            FXMLLoader loader;
            switch (role) {
                case "Admin":
                    loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/TheSystemAdmin_ClaimView.fxml"));
                    break;
                case "PolicyHolder":
                    loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/PolicyHolderView.fxml"));
                    break;
                // Add cases for other roles as necessary
                default:
                    throw new IllegalArgumentException("Invalid role: " + role);
            }

            GridPane roleLayout = loader.load();
            Scene scene = new Scene(roleLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
