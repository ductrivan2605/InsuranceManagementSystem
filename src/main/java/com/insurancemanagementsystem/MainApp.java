//package com.insurancemanagementsystem;
//
//import com.insurancemanagementsystem.controller.SignInController;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//public class MainApp extends Application {
//
//    private Stage primaryStage;
//
//    @Override
//    public void start(Stage primaryStage) {
//        this.primaryStage = primaryStage;
//        this.primaryStage.setTitle("Insurance Management System");
//
//        showSignInView();
//    }
//
//    public void showSignInView() {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/SignIn.fxml"));
//            GridPane signInLayout = loader.load();
//
//            SignInController controller = loader.getController();
//            controller.setMainApp(this);
//
//            Scene scene = new Scene(signInLayout);
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void showViewBasedOnRole(String role) {
//        try {
//            FXMLLoader loader;
//            switch (role) {
//                case "SYSTEM_ADMIN":
//                    loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/TheSystemAdminView.fxml"));
//                    break;
//                case "POLICY_HOLDER":
//                    loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/PolicyHolderView.fxml"));
//                    break;
//                case "POLICY_OWNER":
//                    loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/PolicyHolderOwner.fxml"));
//                    break;
//                case "DEPENDENT":
//                    loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/DependentView.fxml"));
//                    break;
//                case "INSURANCE_SURVEYOR":
//                    loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/InsuranceSurveyorView.fxml"));
//                    break;
//                case "INSURANCE_MANAGER":
//                    loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/InsuranceManagerView.fxml"));
//                    break;
//                // Add cases for other roles as necessary
//                default:
//                    throw new IllegalArgumentException("Invalid role: " + role);
//            }
//
//            GridPane roleLayout = loader.load();
//            Scene scene = new Scene(roleLayout);
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Stage getPrimaryStage() {
//        return primaryStage;
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
package com.insurancemanagementsystem;

import com.insurancemanagementsystem.controller.SignInController;
import com.insurancemanagementsystem.controller.SystemAdminClaimController;
import com.insurancemanagementsystem.controller.SystemAdminPolicyController;
import com.insurancemanagementsystem.controller.SystemAdminUserController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.controlsfx.control.spreadsheet.Grid;

public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Insurance Management System");

        testView();
    }

    public void showSignInView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/SignIn.fxml"));
            GridPane signInLayout = loader.load();

            SignInController controller = loader.getController();
            controller.setMainApp(this);

            Scene scene = new Scene(signInLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // test view for each user type's view - testing purpose will be commented
    public void testView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/TheSystemAdmin_PolicyView.fxml"));
            AnchorPane signInLayout = loader.load();

            SystemAdminPolicyController controller = loader.getController();
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
                case "SYSTEM_ADMIN":
                    loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/TheSystemAdmin_User.fxml"));
                    break;
                case "POLICY_HOLDER":
                    loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/PolicyHolderView.fxml"));
                    break;
                case "POLICY_OWNER":
                    loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/PolicyHolderOwner.fxml"));
                    break;
                case "DEPENDENT":
                    loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/DependentView.fxml"));
                    break;
                case "INSURANCE_SURVEYOR":
                    loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/InsuranceSurveyorView.fxml"));
                    break;
                case "INSURANCE_MANAGER":
                    loader = new FXMLLoader(getClass().getResource("/com/insurancemanagementsystem/InsuranceManagerView.fxml"));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid role: " + role);
            }

            Pane roleLayout = loader.load();
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
