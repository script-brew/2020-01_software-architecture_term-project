package com.rss.controller;

import com.rss.entity.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends Application {

    private User currentUser;

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
        Font.loadFont(getClass().getResourceAsStream("/font/maple_light.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("/font/maple_bold.ttf"), 10);
        primaryStage.setTitle("종교 통합 검색 시스템");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void signIn(ActionEvent actionEvent) {
        try {
            Parent signInWindow = FXMLLoader.load(getClass().getResource("/controller/SignInController.fxml"));
            Scene signInScene = new Scene(signInWindow);
            Stage currentStage = (Stage) signIn.getScene().getWindow();
            currentStage.setScene(signInScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signUp(ActionEvent actionEvent) {
        try {
            Parent signUpWindow = FXMLLoader.load(getClass().getResource("/controller/SignUpController.fxml"));
            Scene signUpScene = new Scene(signUpWindow);
            Stage currentStage = new Stage();
            currentStage.setScene(signUpScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit(ActionEvent actionEvent) {
        Stage currentStage = (Stage) exit.getScene().getWindow();
        currentStage.close();
    }
}
