package com.javafx.turizmacentesi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class UserDesign implements Initializable {
    @FXML
    HBox hBox;
    @FXML
    Label nameUD,surnameUD,nameUD1,usernameUD,typeUD;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameUD.setOpacity(1);
        surnameUD.setOpacity(1);
        nameUD1.setOpacity(1);
        usernameUD.setOpacity(1);
        typeUD.setOpacity(1);



    }


}
