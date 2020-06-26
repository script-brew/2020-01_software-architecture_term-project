package com.rss.util.dialog;

import com.rss.entity.Address;
import com.rss.entity.Facility;
import com.rss.respond.AddressBody;
import com.rss.respond.RespondFormat;
import com.rss.util.retrofitUtil.APIUtils;
import com.rss.util.retrofitUtil.AddressAPI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddressDialog implements Initializable {
    private AddressAPI addressAPI;
    private static final String confirmKey = "devU01TX0FVVEgyMDIwMDYyNzAwNTYxMjEwOTkwODk=";
    private Address currentAddress;

    @FXML
    private TextField addressField;

    @FXML
    private Button findBtn;

    @FXML
    private Button addBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private ListView<Address> addressList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addressAPI = APIUtils.getAddressAPI();

        addressList.setOnMouseClicked(event -> {
            this.currentAddress = addressList.getSelectionModel().getSelectedItem();
        });
    }

    @FXML
    void find(ActionEvent event) {
        String address = addressField.getText().toString();

        try {
            Call<RespondFormat> call = addressAPI.getAddress(1, 50, address, confirmKey, "json");
            Response<RespondFormat> response = call.execute();
            List<AddressBody> body = response.body().getFormat().getBody();
            System.out.println(body.toString());

            ObservableList<Address> list = FXCollections.observableArrayList();

            for(AddressBody addressBody : body) {
                Address newAddress = new Address(addressBody.getSiNm(), addressBody.getSsgNm(), addressBody.getEmdNm(), addressBody.getLnbrMnnm(), addressBody.getZipNo(), "");
                list.add(newAddress);
            }

            addressList.setItems(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void add(ActionEvent event) {
        if(currentAddress == null) return;

        Stage currentStage = (Stage) addBtn.getScene().getWindow();
        currentStage.setUserData(currentAddress);

        cancel(event);
    }

    @FXML
    void cancel(ActionEvent event) {
        Stage currentStage = (Stage) cancelBtn.getScene().getWindow();
        currentStage.close();
    }

}
