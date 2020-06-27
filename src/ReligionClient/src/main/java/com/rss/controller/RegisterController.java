package com.rss.controller;

import com.rss.entity.Facility;
import com.rss.entity.User;
import com.rss.service.RegisterService;
import com.rss.service.implementation.ServiceFactoryCreator;
import com.rss.util.SystemStatus;
import com.rss.util.dialog.RegisterDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    private ObservableList<Facility> facilities;
    private RegisterService registerService;
    private Facility selectFacility;
    private User currentUser;

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
        facilities = FXCollections.observableArrayList();
        currentUser = SystemStatus.getUser();
        facilityView.setOnMouseClicked(event -> {
            selectFacility = facilityView.getSelectionModel().getSelectedItem();
            System.out.println(selectFacility.toString());
        });
        setItem();
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
        setItem();
    }

    @FXML
    void delete(ActionEvent event) {
        int result = registerService.deleteFac(selectFacility.getId());
        setItem();
    }

    @FXML
    void logout(ActionEvent event) {
        SystemStatus.setUser(null);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/controller/MainController.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) logoutBtn.getScene().getWindow();
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void modify(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/util/RegisterDialog.fxml"));
        try {
            Parent root = loader.load();
            RegisterDialog dialog = loader.getController();
            dialog.setData(facilityView.getSelectionModel().getSelectedItem());
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initOwner(modifyBtn.getScene().getWindow());
            stage.setTitle("시설 변경");
            stage.setScene(scene);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setItem();
    }

    @FXML
    void selectFacility(TouchEvent event) {
        selectFacility = facilityView.getSelectionModel().getSelectedItem();
    }

    private void setItem() {
        List<Facility> list = registerService.findFacByRegUser(currentUser.getId());
        if(list == null) return;

        facilities.setAll(list);

        facilityView.setItems(facilities);
    }
}
