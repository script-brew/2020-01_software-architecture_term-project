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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PosSearchController implements Initializable {
    private SearchService searchService;
    private ObservableList<Facility> facilities;
    private ToggleGroup toggleGroup;
    private User currentUser;

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
    private Button findBtn;

    @FXML
    private RadioButton cityBox;

    @FXML
    private RadioButton guBox;

    @FXML
    private RadioButton dongBox;

    @FXML
    private TextField cityField;

    @FXML
    private TextField guField;

    @FXML
    private TextField dongField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchService = ServiceFactoryCreator.getInstance().getSearchService();
        currentUser = SystemStatus.getUser();
        facilities = FXCollections.observableArrayList();
        tableView.setItems(facilities);
        toggleInit();

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        urlCol.setCellValueFactory(new PropertyValueFactory<>("url"));
        kindCol.setCellValueFactory(new PropertyValueFactory<>("kind"));

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            switch ((String)newValue.getUserData()) {
                case "city" :
                    cityField.setDisable(false);
                    guField.setDisable(true); guField.clear();
                    dongField.setDisable(true); dongField.clear();
                    break;
                case "gu" :
                    cityField.setDisable(true); cityField.clear();
                    guField.setDisable(false);
                    dongField.setDisable(true); dongField.clear();
                    break;
                case "dong" :
                    cityField.setDisable(true); cityField.clear();
                    guField.setDisable(true); guField.clear();
                    dongField.setDisable(false);
                    break;
            }
        });
    }

    @FXML
    void find(ActionEvent event) {
        String address;
        int mode;

        if(cityBox.isSelected()) {
            address = cityField.getText();
            mode = 0;
        } else if (guBox.isSelected()) {
            address = guField.getText();
            mode = 1;
        } else {
            address = dongField.getText();
            mode = 2;
        }
        if(address.equals("")) {
            facilities.clear();
            return;
        }

        List<Facility> facilityList = searchService.findFacByPos(address, mode);
        if(facilityList != null) facilities.setAll(facilityList);
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

    private void toggleInit() {
        toggleGroup = new ToggleGroup();
        cityBox.setToggleGroup(toggleGroup);
        cityBox.setUserData("city");
        guBox.setToggleGroup(toggleGroup);
        guBox.setUserData("gu");
        dongBox.setToggleGroup(toggleGroup);
        dongBox.setUserData("dong");
    }
}
