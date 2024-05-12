package com.javafx.turizmacentesi;


import Model.UserAdmin;
import Model.UserType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class UserAdd implements Initializable {


    @FXML
    TextField name;
    @FXML
    TextField surname;
    @FXML
    TextField username;
    @FXML
    TextField pass;
    @FXML
    ComboBox<String> comboType;
    @FXML
    GridPane gridPane;

    ObservableList<String> userTypes =
            FXCollections.observableArrayList(
                    "ADMIN",
                    "PERSONAL"
            );
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboType.setItems(userTypes);

    }


    @FXML
    public void addUser() {
        if (name.getText().isEmpty() || surname.getText().isEmpty() || username.getText().isEmpty() || pass.getText().isEmpty()|| comboType.getValue() == null) {
            Helper.showFillAlert();
        }else {
            UserAdmin user = (UserAdmin) Login.loginUser;
            if(user.addPersonal(name.getText(),surname.getText(),username.getText(),pass.getText(), UserType.valueOf(comboType.getValue()))){
                Helper.warnAlert("Başarılı","Veri Eklendi", username.getText()+ " kullanıcısı " + comboType.getValue() + " olarak eklendi.");
                Parent parent = new VBox();
                Helper.changeScene(this.getClass(),"adminPanel.fxml",parent);
                Stage stage = (Stage) gridPane.getScene().getWindow();
                stage.close();
            }else {
                Helper.warnAlert("Başarısız","Mevcut Veri", "Bu kullanıcı zaten sistemde mevcut.");
            }

        }

    }

    @FXML
    public void cancel(){
        Parent parent = new VBox();
        Helper.changeScene(this.getClass(),"adminPanel.fxml",parent);
        Stage stage = (Stage) gridPane.getScene().getWindow();
        stage.close();
    }

}

