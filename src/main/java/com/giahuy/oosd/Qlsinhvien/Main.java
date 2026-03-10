package main.java.com.giahuy.oosd.Qlsinhvien;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        StudentDAO dao=new StudentDAO();
        StudentService service=new StudentService();

        while(true){

            System.out.println("1. Thêm SV");
            System.out.println("2. Xóa SV");
            System.out.println("3. Sửa SV");
            System.out.println("4. DS tất cả");
            System.out.println("5. DS theo lớp");
            System.out.println("6. DS theo ngành");
            System.out.println("7. Sắp xếp GPA");
            System.out.println("8. Tìm theo tháng sinh");
            System.out.println("0. Thoát");

            int choice=sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 4:
                    service.showAll();
                    break;

                case 5:
                    System.out.print("Nhập lớp: ");
                    service.showByClass(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Nhập ngành: ");
                    service.showByMajor(sc.nextLine());
                    break;

                case 7:
                    service.sortByGPA();
                    break;

                case 8:
                    System.out.print("Nhập tháng: ");
                    service.findByMonth(sc.nextInt());
                    break;

                case 0:
                    return;
            }
        }
    }
}