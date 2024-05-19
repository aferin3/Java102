package com.javafx.turizmacentesi;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HotelInfo implements Initializable {

    int starCount=0;
    ImageView[] imageViews= new ImageView[5];
    @FXML
    ImageView editButton,checkOk,star1,star2,star3,star4,star5;
    @FXML
    GridPane infoGrid;
    @FXML
    Label nameLabel;
    @FXML
    HBox starHbox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageViews[0] = star1;
        imageViews[1] = star2;
        imageViews[2] = star3;
        imageViews[3] = star4;
        imageViews[4] = star5;

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
