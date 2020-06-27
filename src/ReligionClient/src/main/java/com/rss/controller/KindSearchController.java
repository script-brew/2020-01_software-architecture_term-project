package com.rss.controller;

import com.rss.entity.Address;
import com.rss.entity.Facility;
import com.rss.entity.User;
import com.rss.service.SearchService;
import com.rss.service.implementation.ServiceFactoryCreator;
import com.rss.util.SystemStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class KindSearchController implements Initializable {
    private SearchService searchService;
    private User currentUser;
    private ObservableList<Facility> facilities;
    private ToggleGroup toggleGroup;

    @FXML
    private TableView<Facility> tableView;

    @FXML
    private TableColumn<Facility, String> nameCol;

    @FXML
    private TableColumn<Facility, String> descriptionCol;

    @FXML
    private TableColumn<Facility, Address> addressCol;

    @FXML
    private TableColumn<Facility, String> numberCol;

    @FXML
    private TableColumn<Facility, String> urlCol;

    @FXML
    private TableColumn<Facility, String> kindCol;

    @FXML
    private Button logoutBtn;

    @FXML
    private RadioButton christBox;

    @FXML
    private RadioButton catholicBox;

    @FXML
    private RadioButton buddiBox;

    @FXML
    private RadioButton selfBox;

    @FXML
    private TextField kindField;

    @FXML
    private Button findBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchService = ServiceFactoryCreator.getInstance().getSearchService();
        currentUser = SystemStatus.getUser();
        facilities = FXCollections.observableArrayList();

        tableView.setItems(facilities);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        urlCol.setCellValueFactory(new PropertyValueFactory<>("url"));
        kindCol.setCellValueFactory(new PropertyValueFactory<>("kind"));

        toggleGroup = new ToggleGroup();
        init();
    }

    @FXML
    void find(ActionEvent event) {
        String kind = (String) toggleGroup.getSelectedToggle().getUserData();
        if(kind.equals("직접입력")) kind = kindField.getText();

        if(kind == null && kind.equals("")) return;

        List<Facility> facilityList = searchService.findByCate(kind);
        facilities.setAll(facilityList);
    }

    @FXML
    void logout(ActionEvent event) {
        SystemStatus.setUser(null);
        try {
            Stage currentStage = (Stage) logoutBtn.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/controller/MainController.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        christBox.setToggleGroup(toggleGroup);
        christBox.setUserData("기독교");
        catholicBox.setToggleGroup(toggleGroup);
        catholicBox.setUserData("천주교");
        buddiBox.setToggleGroup(toggleGroup);
        buddiBox.setUserData("불교");
        selfBox.setToggleGroup(toggleGroup);
        selfBox.setUserData("직접입력");
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals(selfBox)) {
                kindField.setDisable(false);
            } else {
                kindField.setDisable(true);
            }
        });
    }
}
