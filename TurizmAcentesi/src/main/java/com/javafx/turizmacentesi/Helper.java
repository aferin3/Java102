package com.javafx.turizmacentesi;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;



import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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

    public static ArrayList<String> getDataFromSql(int id,String columnName,String table){
        ResultSet rs;
        ArrayList<String> data;
        try {
            PreparedStatement ps= DBConnection.getCon().prepareStatement("SELECT hotel.id,"+ columnName +" FROM hotel INNER JOIN " + table + " ON hotel.id = " + table + ".hotelid WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            data = new ArrayList<>();
            while(rs.next()){
                data.add(rs.getString(2));
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String DateFormatter(String date){
        String[] splitDate = date.split("-");
        return splitDate[2]+"/"+splitDate[1]+"/"+splitDate[0];
    }

    public static void editCheckBox(CheckBox[] checkBoxes,ArrayList<String> commonValues,ArrayList<String> specificValues){
        for(CheckBox checkBox : checkBoxes){
            if(checkBox.isSelected()){
                specificValues.add(checkBox.getText());
            }
        }


        for (int i = 0; i < 7; i++) {
            checkBoxes[i].setVisible(true);
            checkBoxes[i].setSelected(false);
            checkBoxes[i].setText(commonValues.get(i));
            if(specificValues.contains(commonValues.get(i))){
                checkBoxes[i].setSelected(true);
            }

        }
    }

    public static void checkBoxOK(CheckBox[] checkBoxes,ArrayList<String> commonValues,ArrayList<String> specificValues,
                                  String tableName, String columnName,int id){
        try {
            final PreparedStatement preparedStatement = DBConnection.getCon().prepareStatement("DELETE FROM "+tableName+" WHERE hotelid=?");
            final PreparedStatement preparedStatement2 = DBConnection.getCon().prepareStatement("INSERT INTO "+tableName+" VALUES (?,?)");
            specificValues.clear();
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            for(CheckBox checkBox:checkBoxes){
                if(checkBox.isSelected()){
                    specificValues.add(checkBox.getText());
                    preparedStatement2.setInt(1,id);
                    preparedStatement2.setString(2,checkBox.getText());
                    preparedStatement2.executeUpdate();
                    //System.out.println(checkBox.getText());
                }
                checkBox.setOpacity(1);
            }
            preparedStatement2.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        for(int i = 0; i <commonValues.size() ; i++){
            if(i<specificValues.size()){
                checkBoxes[i].setText(specificValues.get(i));
                checkBoxes[i].setVisible(true);
                checkBoxes[i].setSelected(true);
            }else{
                checkBoxes[i].setVisible(false);
                checkBoxes[i].setSelected(false);
            }
        }
    }





}
