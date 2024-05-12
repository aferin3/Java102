package com.javafx.turizmacentesi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection conn;

    public Connection connectDB(){
        try {
            this.conn = DriverManager.getConnection(Config.DB_URL,Config.DB_USERNAME,Config.DB_PASS);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.conn;
    }

    public static Connection getCon(){
        DBConnection db = new DBConnection();

        return db.connectDB();

    }




}
