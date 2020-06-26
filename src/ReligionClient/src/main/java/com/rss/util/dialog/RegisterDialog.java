package com.rss.util.dialog;

import com.rss.entity.Address;
import com.rss.entity.Facility;
import com.rss.entity.User;
import com.rss.service.RegisterService;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterDialog implements Initializable {
    private RegisterService registerService;
    private Address currentAddress;
    private User currentUser;
    private Facility currentFacility;

    @FXML
    private TextField nameField;

    @FXML
    private TextField numberField1;

    @FXML
    private TextField numberField2;

    @FXML
    private TextField numberField3;

    @FXML
    private TextField addressField;

    @FXML
    private TextField fulladdrField;

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
        currentUser = SystemStatus.getUser();
        init();

    }

    @FXML
    void add(ActionEvent event) {
        Alert alert;

        if(currentFacility != null) {
            currentFacility.setName(nameField.getText());
            String number = numberField1.getText().toString() + "-" + numberField2.getText().toString() + "-" + numberField3.getText().toString();
            currentFacility.setNumber(number);
            currentFacility.setDescription(descriptionField.getText());
            currentFacility.setUrl(urlField.getText());
            currentFacility.setRegUserId(currentUser.getId());
            if(kindBox.getValue().equals("직접입력"))
                currentFacility.setKind(kindField.getText());
            else
                currentFacility.setKind(kindBox.getValue());
            currentFacility.setAddress(currentAddress);

            int result = registerService.modifyFac(currentFacility);
            if (result > 0) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("수정 결과");
                alert.setHeaderText("수정 성공");
                alert.setContentText("수정에 성공하였습니다.");
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("수정 결과");
                alert.setHeaderText("수정 실패");
                alert.setContentText("수정에 실패하였습니다.");
            }
        } else {
            Facility facility = new Facility();
            facility.setName(nameField.getText());
            String number = numberField1.getText().toString() + "-" + numberField2.getText().toString() + "-" + numberField3.getText().toString();
            facility.setNumber(number);
            facility.setDescription(descriptionField.getText().toString());
            facility.setAddress(currentAddress);
            if(kindBox.getValue().equals("직접입력"))
                facility.setKind(kindField.getText());
            else
                facility.setKind(kindBox.getValue());
            facility.setUrl(urlField.getText().toString());
            facility.setRegUserId(currentUser.getId());

            int id = registerService.registerFacility(facility);
            if (id > 0) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("등록 결과");
                alert.setHeaderText("등록 성공");
                alert.setContentText("등록에 성공하였습니다.");
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("등록 결과");
                alert.setHeaderText("등록 실패");
                alert.setContentText("등록에 실패하였습니다.");
            }
        }
        alert.showAndWait();
        cancel(event);
    }

    @FXML
    void cancel(ActionEvent event) {
        Stage currentStage = (Stage) cancelBtn.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void findAddress(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/util/AddressDialog.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage addressDialog = new Stage();
            addressDialog.initOwner((Stage) findAddressBtn.getScene().getWindow());

            addressDialog.setScene(scene);
            addressDialog.showAndWait();

            Address foundAddress = (Address) addressDialog.getUserData();
            if(foundAddress != null) {
                addressField.setText(foundAddress.getPostalCode());
                String fullAddr = String.format("%s %s %s %d", foundAddress.getCity(), foundAddress.getGu(), foundAddress.getDong(), foundAddress.getZibun());
                fulladdrField.setText(fullAddr);
                currentAddress = foundAddress;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void setData(Facility facility) {
        currentFacility = facility;
        currentAddress = facility.getAddress();
        nameField.setText(facility.getName());
        String[] numbers = facility.getNumber().split("-");
        numberField1.setText(numbers[0]);
        numberField2.setText(numbers[1]);
        numberField3.setText(numbers[2]);

        Address addr = facility.getAddress();
        addressField.setText(addr.getPostalCode());
        fulladdrField.setText(String.format("%s %s %s %d", addr.getCity(), addr.getGu(), addr.getDong(), addr.getZibun()));
        switch (facility.getKind()) {
            case "기독교":
            case "불교":
            case "천주교":
            case "힌두교":
                kindBox.getSelectionModel().select(facility.getKind());
                break;
            default:
                kindBox.getSelectionModel().select("직접입력");
                kindField.setText(facility.getKind());
        }

        urlField.setText(facility.getUrl());
        descriptionField.setText(facility.getDescription());
        
        addBtn.setText("변경");
    }
}
