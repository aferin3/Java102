package com.javafx.turizmacentesi;

import Model.Hotel;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PersonalPanel implements Initializable {

    @FXML
    VBox hotelVbox;

    public static ArrayList<Hotel> hotelList = new ArrayList<>();
    private ArrayList<String> pensions,services,sessions;
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


            //System.out.println(click);
            //System.out.println(hotelList.get(click).getName());
            AnchorPane anchorPane = new AnchorPane();
            try {

                anchorPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("HotelInfo.fxml"));
                Label hotelNameLabel = (Label)anchorPane.getChildren().get(1);

                hotelNameLabel.setText(hotelList.get(click).getName());  // otel ismi buradan ayarlanıyor

                GridPane gridPane =(GridPane)anchorPane.getChildren().get(2);

                HBox yildizHbox =(HBox)gridPane.getChildren().get(9);
                for(int i = 0; i<hotelList.get(click).getStar();i++){
                    ImageView imageView = (ImageView) yildizHbox.getChildren().get(i);
                    imageView.setVisible(true);
                }

                Label idLabel = (Label)anchorPane.getChildren().get(6);
                idLabel.setText(String.valueOf(hotelList.get(click).getId()));
                Label cityLabel = (Label)gridPane.getChildren().get(10);
                cityLabel.setText(hotelList.get(click).getCity());

                Label districtLabel = (Label)gridPane.getChildren().get(11);
                districtLabel.setText(hotelList.get(click).getDistrict());

                Label addressLabel = (Label)gridPane.getChildren().get(12);
                addressLabel.setText(hotelList.get(click).getAddress());

                Label emailLabel = (Label)gridPane.getChildren().get(13);
                emailLabel.setText(hotelList.get(click).getTel());

                Label phoneLabel = (Label)gridPane.getChildren().get(14);
                phoneLabel.setText(hotelList.get(click).getEmail());

                Label sessionSummerLabel = (Label)gridPane.getChildren().get(17);
                sessionSummerLabel.setText("Yaz: " + hotelList.get(click).getSessions().get(0));

                Label sessionWinterLabel = (Label)gridPane.getChildren().get(18);
                sessionWinterLabel.setText("Kış: " + hotelList.get(click).getSessions().get(1));

                GridPane serviceGridPane = (GridPane)gridPane.getChildren().get(15);
                CheckBox checkBox;
                serviceGridPane.setDisable(true);
                int x =0;
                for(String sbox : hotelList.get(click).getServices()){
                    checkBox = (CheckBox) serviceGridPane.getChildren().get(x);
                    checkBox.setText(sbox);
                    checkBox.setSelected(true);
                    checkBox.setVisible(true);
                    checkBox.setOpacity(1);
                    x++;
                }
                //System.out.println(hotelList.get(click).getServices());

                GridPane pensionGridPane = (GridPane) gridPane.getChildren().get(16);
                pensionGridPane.setDisable(true);
                x=0;
                for( String cBox :hotelList.get(click).getPensionTypes()){
                    checkBox = (CheckBox) pensionGridPane.getChildren().get(x);
                    checkBox.setText(cBox);
                    checkBox.setSelected(true);
                    checkBox.setVisible(true);
                    checkBox.setOpacity(1);

                    x++;
                    //System.out.println(hotelList.get(click).getPensionTypes().get(i));
                }




                Stage stage = new Stage();
                stage.setScene(new Scene(anchorPane));
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent windowEvent) {
                        setHotels();
                    }
                });
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

                int id = rs.getInt(1);
                services= Helper.getDataFromSql(id,"sname","services");
                pensions = Helper.getDataFromSql(id,"ptype","pensiontypes");
                ArrayList<String> sesStart= Helper.getDataFromSql(id,"starts","sessions");
                ArrayList<String> sesEnd= Helper.getDataFromSql(id,"ends","sessions");
                sessions = new ArrayList<>();
                for(int i = 0; i<sesStart.size(); i++){
                    sessions.add(Helper.DateFormatter(sesStart.get(i))+ " - " +Helper.DateFormatter(sesEnd.get(i)));
                }



                hotelList.add(new Hotel(id,rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(8),
                        rs.getString(5),rs.getString(6),rs.getInt(7),pensions,services,sessions));
                //System.out.println(sessions);
                hotelVbox.getChildren().add(hBox);



            }


        } catch (Exception e) {
            System.out.println(e);
            System.out.println("hata");
        }


    }

}
