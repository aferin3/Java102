package Model;

import com.javafx.turizmacentesi.DBConnection;

import java.sql.PreparedStatement;
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

    public boolean deleteUser(int ID){
        try {
            PreparedStatement ps = DBConnection.getCon().prepareStatement("DELETE FROM users WHERE ID=?");
            ps.setInt(1,ID);

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {

            return false;
        }


    }
    public boolean userEdit(int ID,String name,String surname,String username,String password,String userType){
        try {
            PreparedStatement ps = DBConnection.getCon().prepareStatement("UPDATE users SET name = ?,surname = ?,username = ?, password = ?, usertype = ? WHERE id = ?");
            ps.setString(1,name);
            ps.setString(2,surname);
            ps.setString(3,username);
            ps.setString(4,password);
            ps.setString(5,userType);
            ps.setInt(6,ID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }

        return true;
    }


}
