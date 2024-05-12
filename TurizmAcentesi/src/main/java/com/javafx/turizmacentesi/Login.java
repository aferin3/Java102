package com.javafx.turizmacentesi;
import Model.UserAdmin;
import Model.UserType;
import Model.Users;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Login implements Initializable{
    @FXML
    VBox loginvBox;
    @FXML
    Button loginBtn;
    @FXML
    TextField userNameTF;
    @FXML
    PasswordField passwordTF;

    public static Users loginUser = null;


    PreparedStatement pst = null;
    String query = "SELECT * from users where username=? and password=?";
    public void logcheck(){



        String username = userNameTF.getText();
        String password = passwordTF.getText();

        if(username.isEmpty() || password.isEmpty()){
            Helper.showFillAlert();
        }else {

            try {
                pst = DBConnection.getCon().prepareStatement(query);
                pst.setString(1,username);
                pst.setString(2,password);
                ResultSet rs = pst.executeQuery();
                // Login olan kullanıcıyı başka sınıflarda da kullanmak için böyle bir tanımlama yaptım.

                if(rs.next()){
                    if(rs.getString("usertype").equals("ADMIN")){
                        loginUser = new UserAdmin(
                                rs.getString("name"),
                                rs.getString("surname"),
                                rs.getString("username"),
                                rs.getString("password"),
                                UserType.ADMIN
                        );
//                        System.out.println("hoşgeldin admin " + loginUser.getName());
                        // login ekranını kapatmak için


                    }
                    Stage stage = (Stage) loginvBox.getScene().getWindow();
                    stage.close();

                    Parent parent = new VBox();
                    Helper.changeScene(this.getClass(),"adminPanel.fxml",parent);


                }else {
                    Helper.warnAlert("Uyarı","Hatalı Giriş","Kullanıcı adı veya şifresi hatalı");
                }




            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    }
    // Password kısmında enter a basıldığında yapılacaklar
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        passwordTF.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                logcheck();
            }
        });
    }
}
