package com.javafx.turizmacentesi;

import Model.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
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
            System.out.println(hotelList.get(click).getName());
            AnchorPane anchorPane = new AnchorPane();
            try {
                anchorPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("HotelInfo.fxml"));
                Label hotelNameLabel = (Label)anchorPane.getChildren().get(3);

                hotelNameLabel.setText(hotelList.get(click).getName());  // otel ismi buradan ayarlanıyor

                GridPane gridPane =(GridPane)anchorPane.getChildren().get(4);

                Label cityLabel = (Label)gridPane.getChildren().get(10);
                cityLabel.setText(hotelList.get(click).getCity());

                Label districtLabel = (Label)gridPane.getChildren().get(11);
                districtLabel.setText(hotelList.get(click).getDistrict());

                Label addressLabel = (Label)gridPane.getChildren().get(12);
                addressLabel.setText(hotelList.get(click).getAddress());

                Label emailLabel = (Label)gridPane.getChildren().get(13);
                emailLabel.setText(hotelList.get(click).getEmail());

                Label phoneLabel = (Label)gridPane.getChildren().get(14);
                phoneLabel.setText(hotelList.get(click).getTel());



                Stage stage = new Stage();
                stage.setScene(new Scene(anchorPane));
                stage.show();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }


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
                        rs.getString(3),rs.getString(4),rs.getString(8),rs.getString(5),rs.getString(6),rs.getInt(7)));

                hotelVbox.getChildren().add(hBox);



            }



        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
