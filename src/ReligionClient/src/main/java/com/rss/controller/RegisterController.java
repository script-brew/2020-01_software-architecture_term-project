package com.rss.controller;

import com.rss.entity.Facility;
import com.rss.service.RegisterService;
import com.rss.service.implementation.ServiceFactoryCreator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    private ObservableList<Facility> facilities;
    private RegisterService registerService;
    private Facility selectFacility;

    @FXML
    private ListView<Facility> facilityView;

    @FXML
    private Button addBtn;

    @FXML
    private Button modifyBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button logoutBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerService = ServiceFactoryCreator.getInstance().getRegisterService();
        facilities = FXCollections.emptyObservableList();
    }

    @FXML
    void add(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/util/RegisterDialog.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage addDialog = new Stage();
            addDialog.initOwner((Stage) addBtn.getScene().getWindow());
            addDialog.setTitle("시설 추가");
            addDialog.setScene(scene);

            addDialog.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void modify(ActionEvent event) {

    }

    @FXML
    void selectFacility(TouchEvent event) {
        selectFacility = facilityView.getSelectionModel().getSelectedItem();
    }

}
