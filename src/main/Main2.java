package main;

import manager.EmployeeManager;
import regex.ChoiceRegex;

import java.io.IOException;
import java.util.Scanner;

public class Main2 {
    public static void main1() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("QUẢN LÝ NHÂN VIÊN");
            System.out.println("-----------------");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Xóa nhân viên theo ID");
            System.out.println("3. Sửa thông tin nhân viên theo ID");
            System.out.println("4. Kiểm tra thông tin nhân viên theo ID");
            System.out.println("5. Thay đổi trạng thái nhân viên theo ID");
            System.out.println("6. Hiển thị danh sách nhân viên");
            System.out.println("7. Hiển thị lương theo ID");
            System.out.println("8. Sắp xếp nhân viên theo ID");
            System.out.println("9. Tìm kiếm nhân viên theo tên");
            System.out.println("10. Đăng xuất");
            System.out.println("Nhập lựa chọn của bạn: ");

            int choice1 = ChoiceRegex.getChoice();
            switch (choice1){
                case 1:
                    try {
                        EmployeeManager.addEmployee();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try {
                        EmployeeManager.removeEmployee();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    try {
                        EmployeeManager.changeInfo();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } break;

                case 4:
                    EmployeeManager.checkInfo();
                    break;

                case 5:
                    try {
                        EmployeeManager.changeStatus();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } break;

                case 6:
                    System.out.println("1. Hiển thị danh sách nhân viên");
                    System.out.println("2. Hiển thị danh sách nhân viên Fulltime");
                    System.out.println("3. Hiển thị danh sách nhân viên Parttime");
                    int choice2 = ChoiceRegex.getChoice();
                    switch (choice2){
                        case 1:
                            EmployeeManager.show();
                            break;
                        case 2:
                            EmployeeManager.show1();
                            break;
                        case 3:
                            EmployeeManager.show2();
                            break;
                    }
                    break;
                case 7:
                    EmployeeManager.showSalary();
                    break;

                case 8:
                    try {
                        EmployeeManager.sort();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 9:
                    EmployeeManager.findByName();
                    break;
                case 10:
                    Main.menuLogin();
                    break;
            }
        }
    }
}
