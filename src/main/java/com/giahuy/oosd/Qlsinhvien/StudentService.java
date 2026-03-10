package main.java.com.giahuy.oosd.Qlsinhvien;

import java.sql.*;
import java.util.*;

public class StudentService {

    public void showAll(){
        try{
            Connection conn=DBConnection.getConnection();
            Statement st=conn.createStatement();

            ResultSet rs=st.executeQuery("SELECT * FROM students");

            while(rs.next()){
                System.out.println(
                        rs.getString("id")+" | "+
                                rs.getString("name")+" | "+
                                rs.getDate("birth")+" | "+
                                rs.getString("major")+" | "+
                                rs.getDouble("gpa")+" | "+
                                rs.getString("className")
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void showByClass(String className){
        try{
            Connection conn=DBConnection.getConnection();

            String sql="SELECT * FROM students WHERE className=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,className);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("name")+" - "+rs.getString("className"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void showByMajor(String major){
        try{
            Connection conn=DBConnection.getConnection();

            String sql="SELECT * FROM students WHERE major=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,major);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("name")+" - "+rs.getString("major"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void sortByGPA(){
        try{
            Connection conn=DBConnection.getConnection();

            String sql="SELECT * FROM students ORDER BY gpa DESC";

            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getString("name")+" - "+rs.getDouble("gpa"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void findByMonth(int month){
        try{
            Connection conn=DBConnection.getConnection();

            String sql="SELECT * FROM students WHERE MONTH(birth)=?";
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setInt(1,month);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("name")+" - "+rs.getDate("birth"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}