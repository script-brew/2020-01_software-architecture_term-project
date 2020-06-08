package com.rss.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController extends Application {

    public static void main(String[] args) {
        Application.launch(args);
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
        Parent root = FXMLLoader.load(getClass().getResource("/MainController.fxml"));
        primaryStage.setTitle("Sample FX");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
