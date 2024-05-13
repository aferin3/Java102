package com.javafx.turizmacentesi;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;



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
    public  static void changeScene(Class aClass, String fxmlFile, Parent parent){
        // Giriş yapıldıktan sonra


        Stage stage = new Stage();
        //parent = null;
        try {
            parent = (Parent) FXMLLoader.load(aClass.getResource(fxmlFile));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        stage.setScene(new Scene(parent));
        stage.setTitle("Patika Turizm Acentesi");
        //stage.initStyle(StageStyle.UNDECORATED);
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

    public static void bigButton(ImageView imageView){
        imageView.setStyle("-fx-opacity: 1.0;");
        imageView.setScaleX(1.2);
        imageView.setScaleY(1.2);
    }
    public static void smallButton(ImageView imageView){
        imageView.setStyle("-fx-opacity: 0.5;");
        imageView.setScaleX(1.0);
        imageView.setScaleY(1.0);

    }


}
