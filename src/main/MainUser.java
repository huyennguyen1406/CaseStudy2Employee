package main;

import manager.EmployeeManager;
import regex.ChoiceRegex;

public class MainUser {
    public static void mainUser() {
        while (true) {
            System.out.println("QUẢN LÝ NHÂN VIÊN");
            System.out.println("-----------------");
            System.out.println("1. Kiểm tra thông tin nhân viên theo ID");
            System.out.println("2. Thay đổi trạng thái nhân viên theo ID");
            System.out.println("3. Hiển thị danh sách nhân viên");
            System.out.println("4. Hiển thị lương theo ID");
            System.out.println("5. Sắp xếp nhân viên theo ID");
            System.out.println("6. Tìm kiếm nhân viên theo tên");
            System.out.println("7. Đăng xuất");
            int choice3 = ChoiceRegex.getChoice();
            switch (choice3) {
                case 1:
                    EmployeeManager.checkInfo();
                    break;
                case 2:
                    try {
                        EmployeeManager.changeStatus();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("1. Hiển thị danh sách nhân viên");
                    System.out.println("1. Hiển thị danh sách nhân viên Fulltime");
                    System.out.println("1. Hiển thị danh sách nhân viên Parttime");
                    int choice4 = ChoiceRegex.getChoice();
                    switch (choice4) {
                        case 1:
                            EmployeeManager.show();
                            break;
                        case 2:
                            EmployeeManager.showFull();
                            break;
                        case 3:
                            EmployeeManager.showPart();
                            break;

                    }
                    break;

                case 4:
                    EmployeeManager.showSalary();
                    break;

                case 5:
                    try {
                        EmployeeManager.sort();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } break;

                case 6:
                    EmployeeManager.findByName();
                    break;

                case 7:
                    Main.menuLogin();
                    break;

            }
        }
    }
}
