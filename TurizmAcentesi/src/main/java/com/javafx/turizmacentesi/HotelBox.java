package com.javafx.turizmacentesi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HotelBox implements Initializable {

    @FXML
    Label hotelNameLabel,cityLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        hotelNameLabel.setOpacity(1);
        cityLabel.setOpacity(1);

    }
}
