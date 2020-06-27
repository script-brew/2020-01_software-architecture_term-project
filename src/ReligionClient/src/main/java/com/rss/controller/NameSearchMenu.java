package com.rss.controller;

import com.rss.entity.Address;
import com.rss.entity.Facility;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NameSearchMenu implements Initializable {
    private SearchService searchService;
    private ObservableList<Facility> facilities;

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
    private TextField nameField;

    @FXML
    private Button findBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchService = ServiceFactoryCreator.getInstance().getSearchService();
        facilities = FXCollections.observableArrayList();
        tableView.setItems(facilities);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        urlCol.setCellValueFactory(new PropertyValueFactory<>("url"));
        kindCol.setCellValueFactory(new PropertyValueFactory<>("kind"));
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

    @FXML
    void find(ActionEvent event) {
        List<Facility> findList = searchService.findByName(nameField.getText());
        System.out.println(findList.toString());
        if(findList != null) {
            facilities.setAll(findList);
        }
    }

}
