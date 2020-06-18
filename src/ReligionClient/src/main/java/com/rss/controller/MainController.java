package com.rss.controller;

import com.rss.entity.User;
import com.rss.entity.UserKind;
import com.rss.service.SignInService;
import com.rss.service.implementation.ServiceFactoryCreator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends Application implements Initializable {

    private User currentUser;
    private SignInService signInService;
    private Stage currentStage;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signIn;

    @FXML
    private Button signUp;

    @FXML
    private Button exit;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            primaryStage.close();
        });

        Parent root = FXMLLoader.load(getClass().getResource("/controller/MainController.fxml"));
        primaryStage.setTitle("종교 통합 검색 시스템");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentUser = null;
        signInService = ServiceFactoryCreator.getInstance().getSignInService();
    }
    @FXML
    public void signIn(ActionEvent actionEvent) {
        try {
            if(currentUser == null) {
                String email = emailField.getText();
                String password = passwordField.getText();
                currentUser = signInService.requestSignIn(email, password);
                if(currentUser == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("로그인");
                    alert.setHeaderText("로그인 실패");
                    alert.setContentText("로그인 정보가 일치하지 않습니다.");
                    alert.showAndWait();
                } else {
                    FXMLLoader loader;
                    if(currentUser.getKind() == UserKind.Register) {
                        loader = new FXMLLoader(getClass().getResource("/controller/RegisterController.fxml"));
                    } else {
                        loader = new FXMLLoader(getClass().getResource("/controller/SearchController.fxml"));
                    }

                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) signIn.getScene().getWindow();
                    stage.setTitle("종교 검색 시스템");
                    stage.setScene(scene);
                    stage.setUserData(currentUser);
                    stage.show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void signUp(ActionEvent actionEvent) {
        try {
            Parent signUpWindow = FXMLLoader.load(getClass().getResource("/controller/SignUpController.fxml"));
            Scene signUpScene = new Scene(signUpWindow);
            Stage currentStage = new Stage();
            Stage owner = (Stage) signUp.getScene().getWindow();
            currentStage.initOwner(owner);
            currentStage.setScene(signUpScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exit(ActionEvent actionEvent) {
        Stage currentStage = (Stage) exit.getScene().getWindow();
        currentStage.close();
    }
}
