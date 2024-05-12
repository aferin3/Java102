package com.javafx.turizmacentesi;


import Model.UserAdmin;

import Model.UserType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminPanel implements Initializable {
    @FXML
    Label welcomeText;
    @FXML
    Label labelID;
    @FXML
    Label labelName;
    @FXML
    Label labelSurname;
    @FXML
    Label labelUserName;
    @FXML
    Label labelPass;
    @FXML
    Label labelType;
    @FXML
    VBox userVbox;
    @FXML
    GridPane infoGrid;
    @FXML
    VBox anaVbox;

    int click=0;

    UserAdmin userAdmin;
    public HBox hBox = new HBox();

    ArrayList<UserAdmin> userAdmins = new ArrayList<>();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        userAdmin =(UserAdmin) Login.loginUser;
        welcomeText.setText(userAdmin.getName() + ", Admin Paneline Hoşgeldin");
//        userAdmin.listUser(userVbox);



        ResultSet rs;

        try {
            PreparedStatement ps = DBConnection.getCon().prepareStatement("select * from users");
            rs = ps.executeQuery();

            while (rs.next()) {

                FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("userDesign.fxml"));

                HBox hBox = fxmlLoader.load();


                Label ID = (Label) hBox.getChildren().get(1);
                ID.setText(rs.getString(1));
                Label nameUD = (Label) hBox.getChildren().get(2);
                nameUD.setText(rs.getString(2));
                Label surnameUD = (Label) hBox.getChildren().get(3);
                surnameUD.setText(rs.getString(3));
                Label userNameUD = (Label) hBox.getChildren().get(4);
                userNameUD.setText(rs.getString(4));
                Label userType = (Label) hBox.getChildren().get(5);
                userType.setText(rs.getString(5));
                String pass = rs.getString(6);

                if(userType.getText().equals("ADMIN")){

                    Image image = new Image(getClass().getResourceAsStream("/images/adminIcon.png"));

                    ImageView imageView = (ImageView) hBox.getChildren().get(0);
                    imageView.setImage(image);
                }


                UserAdmin userAdminX =new UserAdmin(nameUD.getText(),surnameUD.getText(),userNameUD.getText(),pass, UserType.valueOf(userType.getText()));
                userAdminX.setUserID(rs.getInt(1));
                userAdmins.add(userAdminX);

                userVbox.getChildren().add(hBox);
            }



            rs.close();
            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        userVbox.setOnMouseClicked(event ->

        {






            try {
                if (!hBox.equals(null)) {
                    hBox.setStyle("-fx-background-color: transparent;");
                }
                Object target = event.getTarget();
                if (target instanceof Node) {
                    if(target instanceof VBox){             //tıklanan öğe eğer vbox ın kendisi ise bir işlem veya hata yapmasın diye
                        System.out.println("bu bir vbox");
                    }else {
                        ((Node) target).setStyle("-fx-background-color: #4299CF");  // öğeye tıklandığında renk değiştirmesi için
                        hBox = (HBox) target;
                        click = userVbox.getChildren().indexOf(target);
                    }
                }
            }catch (Exception e){
                System.out.println(e);
            }

            infoGrid.setVisible(true);
            //click = userVbox.getChildren().indexOf(target);


            //System.out.println(userAdmins.get(click).getUserID());
            //click =0;

            labelID.setText(String.valueOf(userAdmins.get(click).getUserID()));
            labelName.setText(userAdmins.get(click).getName());
            labelSurname.setText(userAdmins.get(click).getSurname());
            labelUserName.setText(userAdmins.get(click).getUsername());
            labelPass.setText(userAdmins.get(click).getPassword());
            labelType.setText(userAdmins.get(click).getUserType().toString());


        });


    }

    public void addUser() {
        Parent parent = new GridPane();
        Helper.changeScene(this.getClass(),"userAdd.fxml",parent);
        Stage stage = (Stage) anaVbox.getScene().getWindow();
        stage.close();

    }

    public void deleteUser(){
        if (Helper.onay("Onay","Emin misiniz", userAdmins.get(click).getUsername(),"Sil","İptal")){
            userVbox.getChildren().remove(click);

            userAdmin.deleteUser(userAdmins.get(click).getUserID());
            userAdmins.remove(click);

        }else{
            System.out.println("olmadı");
        }

    }


}
