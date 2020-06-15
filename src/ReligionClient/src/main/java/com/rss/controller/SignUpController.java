package com.rss.controller;

import com.rss.service.SignUpService;
import com.rss.service.implementation.ServiceFactoryCreator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class SignUpController implements Initializable {

    private SignUpService signUpService;

    private ToggleGroup toggleGroup;

    @FXML
    private TextField emailFront;

    @FXML
    private Button emailBtn;

    @FXML
    private ChoiceBox<String> emailBack;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField passwordReField;

    @FXML
    private Button passwordBtn;

    @FXML
    private TextField nameField;

    @FXML
    private TextField numberField1;

    @FXML
    private TextField numberField2;

    @FXML
    private TextField numberField3;

    @FXML
    private ChoiceBox<Integer> year;

    @FXML
    private ChoiceBox<Integer> month;

    @FXML
    private ChoiceBox<Integer> day;

    @FXML
    private RadioButton searchRadio;

    @FXML
    private RadioButton registerRadio;

    @FXML
    private Button signUpBtn;

    @FXML
    private Button cancelBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(location.toString());
        signUpService = ServiceFactoryCreator.getInstance().getSignUpService();
        toggleGroup = new ToggleGroup();
        searchRadio.setToggleGroup(toggleGroup);
        registerRadio.setToggleGroup(toggleGroup);

    }

    @FXML
    void cancel(ActionEvent event) {
        Stage currentStage = (Stage) cancelBtn.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void isEmailExist(ActionEvent event) {
        String email = emailFront.getText() + "@" + emailBack.getValue();
        boolean isEmailExist = signUpService.isEmailExist(email);
        if(true) {
            Stage existStage = new Stage();
            Label existLabel = new Label("이메일이 중복되었습니다.");
            Button okayBtn = new Button("확인");
            BorderPane pane = new BorderPane();
            pane.setCenter(existLabel);
            pane.setBottom(okayBtn);
            okayBtn.setOnAction(event1 -> {
                existStage.close();
            });
            Scene scene = new Scene(pane, 250, 100);
            existStage.setScene(scene);
            existStage.show();
        }
    }

    @FXML
    void isPasswordSame(ActionEvent event) {

    }

    @FXML
    void signUp(ActionEvent event) {

    }

}
