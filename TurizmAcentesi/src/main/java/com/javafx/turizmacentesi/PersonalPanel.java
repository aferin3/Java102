package com.javafx.turizmacentesi;

import Model.Hotel;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.w3c.dom.ls.LSOutput;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PersonalPanel implements Initializable {

    @FXML
    VBox hotelVbox;

    public static ArrayList<Hotel> hotelList = new ArrayList<>();
    HBox hBox = new HBox();

    int click = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setHotels();

        hotelVbox.setOnMouseClicked(event ->

        {
            try {

                Object target = event.getTarget();
                if (target instanceof Node) {
                    if (target instanceof VBox) {             //tıklanan öğe eğer vbox ın kendisi ise bir işlem veya hata yapmasın diye
                        System.out.println("bu bir vbox");
                    } else {

                        hBox = (HBox) target;
                        click = hotelVbox.getChildren().indexOf(target);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }


            System.out.println(click);

        });

    }

    public void setHotels(){
        hotelVbox.getChildren().clear();
        ResultSet rs;
        try {
            PreparedStatement pst = DBConnection.getCon().prepareStatement("SELECT * FROM HOTEL ORDER BY id");
            rs = pst.executeQuery();
            hotelList.clear();


            while (rs.next()) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hotelBox.fxml"));
                HBox hBox = fxmlLoader.load();

                GridPane gridPane = (GridPane) hBox.getChildren().get(1);
                Label hotelNameLabel = (Label) gridPane.getChildren().get(0);
                hotelNameLabel.setText(rs.getString(2));
                Label hotelCityLabel = (Label) gridPane.getChildren().get(6);
                hotelCityLabel.setText(rs.getString(4));


                //yıldız hesabı
                int starCount = rs.getInt(7);

                ImageView[] imageViews = new ImageView[starCount];
                for (int i = 0; i < starCount; i++) {
                    imageViews[i] = (ImageView) gridPane.getChildren().get(i+1);
                    imageViews[i].setVisible(true);
                }

                hotelList.add(new Hotel(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));

                hotelVbox.getChildren().add(hBox);



            }



        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
