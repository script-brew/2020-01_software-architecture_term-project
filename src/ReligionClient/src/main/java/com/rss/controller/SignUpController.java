package com.rss.controller;

import com.rss.entity.User;
import com.rss.entity.UserKind;
import com.rss.service.SignUpService;
import com.rss.service.implementation.ServiceFactoryCreator;
import com.rss.util.dialog.PasswordDialog;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.FXPermission;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.*;
import java.util.logging.Logger;

public class SignUpController implements Initializable {

    private SignUpService signUpService;

    private ToggleGroup toggleGroup;

    private ObservableList<String> emailList;

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
    private ChoiceBox<String> year;

    @FXML
    private ChoiceBox<String> month;

    @FXML
    private ChoiceBox<String> day;

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
        emailList = FXCollections.observableList(new ArrayList<>());
        emailList.add("gmail.com");
        emailList.add("naver.com");
        emailList.add("hanmail.com");
        signUpService = ServiceFactoryCreator.getInstance().getSignUpService();
        toggleGroup = new ToggleGroup();
        searchRadio.setToggleGroup(toggleGroup);
        registerRadio.setToggleGroup(toggleGroup);
        emailBack.setItems(emailList);
        setBirthdayList();

    }

    @FXML
    void cancel(ActionEvent event) {
        Stage currentStage = (Stage) cancelBtn.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void isEmailExist(ActionEvent event) {
        String email = emailFront.getText() + "@" + emailBack.getValue();
        System.out.println(email);
        boolean isEmailExist = signUpService.isEmailExist(email);
//        try {

//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @FXML
    void isPasswordSame(ActionEvent event) {
        boolean isSame = signUpService.checkPassword(passwordField.getText(), passwordReField.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/util/PasswordDialog.fxml"));
        try {
            Parent root = loader.load();
            PasswordDialog passwordDialog = loader.<PasswordDialog>getController();
            Stage stage = new Stage();
            Stage ownerStage = (Stage) passwordBtn.getScene().getWindow();
            stage.initOwner(ownerStage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            passwordDialog.recieveData(isSame);
            stage.showAndWait();

            boolean result = (boolean) stage.getUserData();
            permisssionPassword(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void signUp(ActionEvent event) {
        try {
            //user info
            String email = emailFront.getText() + "@" + emailBack.getValue();
            String password = passwordField.getText();
            String name = nameField.getText();
            String number = numberField1.getText() + numberField2.getText() + numberField3.getText();
            String birthday = year.getValue() + month.getValue() + day.getValue();
            UserKind kind = searchRadio.isSelected() ? UserKind.Search : UserKind.Register;

            User newUser = new User(email, password, name, number, birthday, kind);
            int result = signUpService.requestSignUp(newUser);

            Alert signUpAlert = new Alert(Alert.AlertType.INFORMATION);
            signUpAlert.setTitle("회원가입 정보");

            if(result > 0) {
                signUpAlert.setHeaderText("회원가입 성공");
                signUpAlert.setContentText("회원가입에 성공하였습니다.");
                signUpAlert.showAndWait();
                cancel(event);
            } else {
                signUpAlert.setHeaderText("회원가입 실패");
                signUpAlert.setContentText("회원가입에 실패하였습니다.");
                signUpAlert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void permisssionPassword(boolean permission) {
        if(permission) {
            passwordReField.setDisable(true);
            passwordField.setDisable(true);
        } else {
            passwordReField.setDisable(false);
            passwordField.setDisable(false);

        }
    }
    private void setBirthdayList() {
        List<String> yearList = new ArrayList<>();
        List<String> monthList = new ArrayList<>();
        List<String> dayList = new ArrayList<>();
        for(int i = 1950; i < 2021; i++) {
            yearList.add(Integer.toString(i));
        }

        for(int i = 1; i <= 12; i++) {
            if(i < 10)
                monthList.add("0" + i);
            else
                monthList.add(Integer.toString(i));
        }

        for(int i = 1; i <= 31; i++) {
            if(i < 10)
                dayList.add("0"+i);
            else
                dayList.add(Integer.toString(i));
        }

        year.setItems(FXCollections.observableList(yearList));
        month.setItems(FXCollections.observableList(monthList));
        day.setItems(FXCollections.observableList(dayList));
    }

}
