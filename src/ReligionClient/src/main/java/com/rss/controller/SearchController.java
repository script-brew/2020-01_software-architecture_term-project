package com.rss.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    private Tab nameTab;

    @FXML
    private AnchorPane nameView;

    @FXML
    private Tab kindTab;

    @FXML
    private AnchorPane kindView;

    @FXML
    private Tab addressTab;

    @FXML
    private AnchorPane addressView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FXMLLoader nameLoader = new FXMLLoader(getClass().getResource("/controller/NameMenu.fxml"));
            nameView = nameLoader.load();
            nameTab.setContent(nameView);
            FXMLLoader kindLoader = new FXMLLoader(getClass().getResource("/controller/KindMenu.fxml"));
            kindView = kindLoader.load();
            kindTab.setContent(kindView);
            FXMLLoader addressLoader = new FXMLLoader(getClass().getResource("/controller/AddressMenu.fxml"));
            addressView = addressLoader.load();
            addressTab.setContent(addressView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
