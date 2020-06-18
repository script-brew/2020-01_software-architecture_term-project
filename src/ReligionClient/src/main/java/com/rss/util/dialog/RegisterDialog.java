package com.rss.util.dialog;

import com.rss.entity.Facility;
import com.rss.entity.FacilityKind;
import com.rss.service.RegisterService;
import com.rss.service.implementation.ServiceFactoryCreator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterDialog implements Initializable {
    private RegisterService registerService;

    @FXML
    private TextField nameField;

    @FXML
    private TextField numberField1;

    @FXML
    private TextField numberField2;

    @FXML
    private TextField numberField3;

    @FXML
    private Button findAddressBtn;

    @FXML
    private ChoiceBox<String> kindBox;

    @FXML
    private TextField kindField;

    @FXML
    private TextField urlField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private Button addBtn;

    @FXML
    private Button cancelBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerService = ServiceFactoryCreator.getInstance().getRegisterService();
        init();

    }

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void findAddress(ActionEvent event) {

    }

    private void init() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("기독교");
        list.add("불교");
        list.add("천주교");
        list.add("힌두교");
        list.add("직접입력");
        
        kindBox.setItems(list);
        kindBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals("직접입력")) {
                kindField.setDisable(false);
            } else {
                kindField.setDisable(true);
            }
        });
    }
}
