package com.insurancemanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/PolicyHolderView.fxml"));
        BorderPane root = loader.load();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Policy Holders Dashboard");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
