package main.java.com.giahuy.oosd.Qlsinhvien;

import java.time.LocalDate;

public class Student {
    private String id;
    private String name;
    private LocalDate birth;
    private String major;
    private double gpa;
    private String className;

    public Student(String id, String name, LocalDate birth, String major, double gpa, String className) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.major = major;
        this.gpa = gpa;
        this.className = className;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public LocalDate getBirth() { return birth; }
    public String getMajor() { return major; }
    public double getGpa() { return gpa; }
    public String getClassName() { return className; }

    public void setName(String name) { this.name = name; }
    public void setBirth(LocalDate birth) { this.birth = birth; }
    public void setMajor(String major) { this.major = major; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public void setClassName(String className) { this.className = className; }

    public void display(){
        System.out.println(id+" | "+name+" | "+birth+" | "+major+" | "+gpa+" | "+className);
    }
}