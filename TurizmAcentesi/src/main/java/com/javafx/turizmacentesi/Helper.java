package com.javafx.turizmacentesi;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;


public class Helper {

    public static void showFillAlert(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Uyarı");
        alert.setHeaderText("Eksik Alan");
        alert.setContentText("Lütfen tüm boşlukları doldurun.");

        alert.showAndWait();
    }

    public static void warnAlert(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
    public  static void changeScene(Class aClass, String fxmlFile, Parent root){
        // Giriş yapıldıktan sonra


        Stage stage = new Stage();
        root = null;
        try {
            root = (Parent) FXMLLoader.load(aClass.getResource(fxmlFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setScene(new Scene(root));
        stage.setTitle("Patika Turizm Acentesi");
        stage.initModality(Modality.WINDOW_MODAL);


        stage.show();



    }
    public static boolean onay(String title, String header, String content,String OkButtonText, String CancelButtonText){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        ButtonType yes = new ButtonType(OkButtonText);
        ButtonType no = new ButtonType(CancelButtonText);
        alert.getButtonTypes().setAll(yes, no);
        var result = alert.showAndWait();

        return result.isPresent() && result.get() == yes;
    }

}
