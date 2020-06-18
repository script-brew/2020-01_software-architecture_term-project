package com.rss.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class NameSearchMenu implements Initializable {

    @FXML
    private AnchorPane nameView;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> descriptionCol;

    @FXML
    private TableColumn<?, ?> addressField;

    @FXML
    private TableColumn<?, ?> numberCol;

    @FXML
    private TableColumn<?, ?> urlCol;

    @FXML
    private TableColumn<?, ?> kindCol;

    @FXML
    private Button quitBtn;

    @FXML
    private TextField nameField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void quit(ActionEvent event) {

    }

}
