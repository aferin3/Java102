package Model;

import com.javafx.turizmacentesi.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAdmin extends Users{
    public UserAdmin(String name, String surname, String username, String password,UserType userType) {
        super(name, surname, username, password,userType);
    }

    public Boolean addPersonal(String name, String surname,String username, String password,UserType userType){
        try {
            PreparedStatement ps = DBConnection.getCon().prepareStatement(
                    "INSERT INTO users (name,surname,username,usertype,password) VALUES (?,?,?,?,?)"
            ) ;
            ps.setString(1,name);
            ps.setString(2,surname);
            ps.setString(3,username);
            ps.setString(4,userType.toString());
            ps.setString(5,password);


            ps.executeUpdate();
            System.out.println("işleniyor");

            ps.close();
            return true;


        } catch (SQLException e) {
            if(e.getSQLState().equals("23505")){
                System.out.println("bu kullancı var");
                return false;
            }
        }
        return true;
    }

    public void deleteUser(){

    }


}
