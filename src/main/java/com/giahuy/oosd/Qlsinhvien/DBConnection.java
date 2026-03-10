package main.java.com.giahuy.oosd.Qlsinhvien;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            String url="jdbc:mysql://localhost:3306/qlsinhvien";
            String user="root";
            String password="";

            return DriverManager.getConnection(url,user,password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}