package main;

import manager.EmployeeManager;
import regex.ChoiceRegex;

public class MainUser {
    public static void mainUser() {
        while (true) {
            System.out.println("QUẢN LÝ NHÂN VIÊN");
            System.out.println("-----------------");
            System.out.println("1. Kiểm tra thông tin nhân viên theo ID");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Sắp xếp nhân viên theo ID");
            System.out.println("4. Tìm kiếm nhân viên theo tên");
            System.out.println("5. Đăng xuất");
            int choice3 = ChoiceRegex.getChoice();
            switch (choice3) {
                case 1:
                    try {
                        EmployeeManager.checkInfo();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try {
                        System.out.println("1. Hiển thị danh sách nhân viên");
                        EmployeeManager.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    try {
                        EmployeeManager.sort();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    try {
                        EmployeeManager.findByName();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    Main.menuLogin();
                    break;
            }
        }
    }
}
