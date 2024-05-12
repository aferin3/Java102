package com.javafx.turizmacentesi;


import Model.UserAdmin;

import Model.UserType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
    Label welcomeText, labelID,labelName,labelSurname,labelUserName,labelPass,labelType;
    @FXML
    TextField editName,editSurname,editUsername,editPass;
    @FXML
    ComboBox<String> editType;
    @FXML
    VBox userVbox;

    @FXML
    VBox anaVbox;
    @FXML
    ImageView checkOk,dustButton,addButton,editButton;


    @FXML
    AnchorPane usersAnchor,infoAnchor;

    int click=0;

    UserAdmin userAdmin;
    public HBox hBox = new HBox();

    ArrayList<UserAdmin> userAdmins = new ArrayList<>();


    ObservableList<String> userTypes =
            FXCollections.observableArrayList(
                    "ADMIN",
                    "PERSONAL"
            );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        editType.setItems(userTypes);



        userAdmin =(UserAdmin) Login.loginUser;
        welcomeText.setText(userAdmin.getName() + ", Admin Paneline Hoşgeldin");
//        userAdmin.listUser(userVbox);



        setUsers();

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


            //click = userVbox.getChildren().indexOf(target);


            //System.out.println(userAdmins.get(click).getUserID());
            //click =0;

            clickUser(click);


        });


    }

    private void clickUser(int location) {

        infoAnchor.setVisible(true);
        labelID.setText(String.valueOf(userAdmins.get(location).getUserID()));
        labelName.setText(userAdmins.get(location).getName());
        labelSurname.setText(userAdmins.get(location).getSurname());
        labelUserName.setText(userAdmins.get(location).getUsername());
        labelPass.setText(userAdmins.get(location).getPassword());
        labelType.setText(userAdmins.get(location).getUserType().toString());
    }

    private void setUsers() {
        userVbox.getChildren().remove(0, userVbox.getChildren().size());
        ResultSet rs;

        try {
            PreparedStatement ps = DBConnection.getCon().prepareStatement("select * from users ORDER BY id");
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
            clickUser(0);

        }else{
            System.out.println("olmadı");

        }

    }
    @FXML
    public void userEdit(){
        if(editButton.isVisible()){
            checkOk.setVisible(true);
            editButton.setVisible(false);

            editName.setText(labelName.getText());
            editSurname.setText(labelSurname.getText());
            editUsername.setText(labelUserName.getText());
            editPass.setText(labelPass.getText());

            editType.setValue(labelType.getText());  //comboBox varsayılan değeri ayarladık


            addButton.setVisible(false);
            dustButton.setVisible(false);

            editName.setVisible(true);
            editSurname.setVisible(true);
            editUsername.setVisible(true);
            editType.setVisible(true);
            editPass.setVisible(true);







        }else {
            checkOk.setVisible(false);
            editButton.setVisible(true);
            editName.setVisible(false);
            editSurname.setVisible(false);
            editUsername.setVisible(false);
            editType.setVisible(false);
            editPass.setVisible(false);

            addButton.setVisible(true);
            dustButton.setVisible(true);


            userAdmin.userEdit(Integer.parseInt(labelID.getText()),editName.getText(),editSurname.getText(),editUsername.getText(),editPass.getText(),editType.getValue());
            userAdmins.get(click).setName(editName.getText());
            userAdmins.get(click).setSurname(editSurname.getText());
            userAdmins.get(click).setUsername(editUsername.getText());
            userAdmins.get(click).setPassword(editPass.getText());
            userAdmins.get(click).setUserType(UserType.valueOf(editType.getValue()));


            setUsers();
            clickUser(click);
        }
    }


}
