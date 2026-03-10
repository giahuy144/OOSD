package main.java.com.giahuy.oosd.Qlsinhvien;

import java.time.LocalDate;
import java.time.Period;

public class Validate {

    public static boolean checkAge(LocalDate birth){
        int age = Period.between(birth,LocalDate.now()).getYears();
        return age>=15 && age<=110;
    }

    public static boolean checkGPA(double gpa){
        return gpa>=0 && gpa<=10;
    }

    public static boolean checkMajor(String major){
        return major.equals("CNTT") || major.equals("KTPM");
    }

    public static boolean checkID(String id,String major){

        if(major.equals("CNTT"))
            return id.matches("455105\\d{4}");

        if(major.equals("KTPM"))
            return id.matches("455109\\d{4}");

        return false;
    }

    public static String normalizeName(String name){
        name = name.trim().toLowerCase();
        String[] words = name.split("\\s+");

        String result="";

        for(String w:words){
            result+=Character.toUpperCase(w.charAt(0))+w.substring(1)+" ";
        }

        return result.trim();
    }
}