package com.javafx.turizmacentesi;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HotelInfo implements Initializable {

    ImageView[] imageViews= new ImageView[5];
    @FXML
    ImageView editButton,checkOk,star1,star2,star3,star4,star5;

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
                    for(int j=0;j<k+1;j++){
                        imageViews[j].setOpacity(1);
                    }
                }
            });


        }

    }

    @FXML
    public void bigger(MouseEvent event){
        ImageView imageView = (ImageView) event.getSource();

        Helper.bigButton(imageView);
    }
    @FXML
    public void opak(MouseEvent event){
        ImageView imageView = (ImageView) event.getSource();

        Helper.smallButton(imageView);
    }
    @FXML
    public void editHotel(MouseEvent event){



        for(int i = 0; i < 5; i++){
            imageViews[i].setVisible(true);
            imageViews[i].setOpacity(0.6);
        }

        editButton.setVisible(false);
        checkOk.setVisible(true);
    }
    @FXML
    void editOK(){
        editButton.setVisible(true);
        checkOk.setVisible(false);
    }
}
