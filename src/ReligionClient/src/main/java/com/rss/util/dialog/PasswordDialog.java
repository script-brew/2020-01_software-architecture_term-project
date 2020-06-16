package com.rss.util.dialog;

import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PasswordDialog implements Initializable {
    private boolean permission;
    @FXML
    private Label info;

    @FXML
    private Button okayBtn;

    @FXML
    private Button cancelBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    void cancel(ActionEvent event) {
        Stage currentWindow = (Stage) cancelBtn.getScene().getWindow();
        currentWindow.close();
    }

    @FXML
    void okay(ActionEvent event) {
        Stage currentWindow = (Stage) cancelBtn.getScene().getWindow();
        if(permission) currentWindow.setUserData(true);
        else currentWindow.setUserData(false);
        currentWindow.close();
    }

    public void recieveData(boolean data) {
        permission = data;
        if(data) info.setText("비밀번호가 일치합니다.");
        else info.setText("비밀번호가 불일치합니다.");
    }

}
