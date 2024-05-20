package com.javafx.turizmacentesi;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.*;

public class HotelInfo implements Initializable {

    int starCount=0;
    ImageView[] imageViews= new ImageView[5];
    @FXML
    ImageView editButton,checkOk,star1,star2,star3,star4,star5;
    @FXML
    GridPane serviceGrid,pensionGrid;
    @FXML
    Label nameLabel;
    @FXML
    HBox starHbox;
    @FXML
    TextField cityTextField,districtTextField,addressTextField,telTextField,emailTextField;
    @FXML
    Label cityLabel,districtLabel,addressLabel,telLabel,emailLabel;
    @FXML
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,
            checkBox8,checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14;

    CheckBox[] serviceCheckBoxes=new CheckBox[7];
    CheckBox[] pensionCheckBoxes=new CheckBox[7];

    ArrayList<String> services=new ArrayList<>();
    ArrayList<String> pensions=new ArrayList<>();
    ArrayList<String> objectServices;
    ArrayList<String> objectPensions;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Collections.addAll(services, "Ücretsiz Otopark", "Ücretsiz Wifi","Yüzme Havuzu","Fitness Center","Hotel Concierge","SPA","7/24 Oda Servisi");
        Collections.addAll(pensions,"Ultra Her Şey Dahil","Herşey Dahil","Oda Kahvaltı", "Tam Pansiyon","Yarım Pansiyon","Sadece Yatak","Alkol Hariç Full Credit");

        imageViews[0] = star1;
        imageViews[1] = star2;
        imageViews[2] = star3;
        imageViews[3] = star4;
        imageViews[4] = star5;

        serviceCheckBoxes[0]=checkBox1;
        serviceCheckBoxes[1]=checkBox2;
        serviceCheckBoxes[2]=checkBox3;
        serviceCheckBoxes[3]=checkBox4;
        serviceCheckBoxes[4]=checkBox5;
        serviceCheckBoxes[5]=checkBox6;
        serviceCheckBoxes[6]=checkBox7;

        pensionCheckBoxes[0]=checkBox8;
        pensionCheckBoxes[1]=checkBox9;
        pensionCheckBoxes[2]=checkBox10;
        pensionCheckBoxes[3]=checkBox11;
        pensionCheckBoxes[4]=checkBox12;
        pensionCheckBoxes[5]=checkBox13;
        pensionCheckBoxes[6]=checkBox14;





        for (int i = 0; i < 5; i++) {
            final int k = i;
            imageViews[i].setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    for(int j=0;j<5;j++){
                        if(j<=k){
                            imageViews[j].setOpacity(1);
                        }else {
                            imageViews[j].setOpacity(0.6);
                        }

                    }
                }
            });
        }



        starHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                for (int i = 0; i < 5; i++) {
                    if(i<starCount){
                        imageViews[i].setOpacity(1);
                    }else {
                        imageViews[i].setOpacity(0.6);
                    }

                }
            }
        });

        for (int i = 0; i < 5; i++) {
            final  int k = i;
            imageViews[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ImageView imageView = (ImageView) mouseEvent.getSource();
                    switch (imageView.getId()){
                        case "star1":
                            starCount = 1;
                            break;
                        case "star2":
                            starCount = 2;
                            break;
                        case "star3":
                            starCount = 3;
                            break;
                        case "star4":
                            starCount = 4;
                            break;
                        case "star5":
                            starCount = 5;
                            break;
                    }
                }
            });
        }

    }


    @FXML
    public void bigger(MouseEvent event){
        ImageView imageView = (ImageView) event.getSource();

        Helper.bigButton(imageView);
        System.out.println(starCount);
    }
    @FXML
    public void opak(MouseEvent event){
        ImageView imageView = (ImageView) event.getSource();

        Helper.smallButton(imageView);
    }
    @FXML
    public void editHotel(MouseEvent event){


        serviceGrid.setDisable(false);
        objectServices= new ArrayList<>();
        Helper.editCheckBox(serviceCheckBoxes,services,objectServices);

        pensionGrid.setDisable(false);
        objectPensions= new ArrayList<>();
        Helper.editCheckBox(pensionCheckBoxes,pensions,objectPensions);

        cityTextField.setText(cityLabel.getText());
        cityTextField.setVisible(true);

        districtTextField.setText(districtLabel.getText());
        districtTextField.setVisible(true);

        addressTextField.setText(addressLabel.getText());
        addressTextField.setVisible(true);

        telTextField.setText(telLabel.getText());
        telTextField.setVisible(true);

        emailTextField.setText(emailLabel.getText());
        emailTextField.setVisible(true);


        starHbox.setDisable(false);

        for(int i = 0; i < 5; i++){
            if(imageViews[i].isVisible()){
                imageViews[i].setOpacity(1);
                starCount++;
            }else {
                imageViews[i].setOpacity(0.6);
                imageViews[i].setVisible(true);
            }

        }

        editButton.setVisible(false);
        checkOk.setVisible(true);
    }
    @FXML
    void editOK(){

        serviceGrid.setDisable(true);
        pensionGrid.setDisable(true);
        Helper.checkBoxOK(serviceCheckBoxes,services,objectServices);
        Helper.checkBoxOK(pensionCheckBoxes,pensions,objectPensions);


        cityTextField.setVisible(false);
        districtTextField.setVisible(false);
        addressTextField.setVisible(false);
        telTextField.setVisible(false);
        emailTextField.setVisible(false);


        starHbox.setDisable(true);
        editButton.setVisible(true);
        checkOk.setVisible(false);

        for (int i = 0; i < 5; i++) {
            if(i>=starCount){
                imageViews[i].setVisible(false);
            }
        }
        starCount = 0;
    }
}
