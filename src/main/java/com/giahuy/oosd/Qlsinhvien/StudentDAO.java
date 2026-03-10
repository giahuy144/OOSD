package main.java.com.giahuy.oosd.Qlsinhvien;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

    public void addStudent(Student s){
        try{
            Connection conn = DBConnection.getConnection();

            String sql="INSERT INTO students VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,s.getId());
            ps.setString(2,s.getName());
            ps.setDate(3,Date.valueOf(s.getBirth()));
            ps.setString(4,s.getMajor());
            ps.setDouble(5,s.getGpa());
            ps.setString(6,s.getClassName());

            ps.executeUpdate();
            System.out.println("Thêm sinh viên thành công");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteStudent(String id){
        try{
            Connection conn = DBConnection.getConnection();
            String sql="DELETE FROM students WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);

            ps.executeUpdate();
            System.out.println("Đã xóa sinh viên");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateStudent(Student s){
        try{
            Connection conn = DBConnection.getConnection();

            String sql="UPDATE students SET name=?,birth=?,major=?,gpa=?,className=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,s.getName());
            ps.setDate(2,Date.valueOf(s.getBirth()));
            ps.setString(3,s.getMajor());
            ps.setDouble(4,s.getGpa());
            ps.setString(5,s.getClassName());
            ps.setString(6,s.getId());

            ps.executeUpdate();

            System.out.println("Cập nhật thành công");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}