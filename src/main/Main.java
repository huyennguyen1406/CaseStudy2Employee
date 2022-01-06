package main;

import manager.AccountManager;
import regex.ChoiceRegex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menuLogin();
    }

    public static void menuLogin() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("HỆ THỐNG ĐĂNG NHẬP");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("3. Xóa tài khoản");
            System.out.println("4. Hiển thị tài khoản");
            int choice = ChoiceRegex.getChoice();

            switch (choice) {
                case 1:
                    int choice1 = AccountManager.signIn();
                    if (choice1 == 1) {
                        Main3.main2();
                        break;
                    } else if (choice1 == 2) {
                        Main2.main1();
                        break;
                    } else {
                        System.out.println("Tài khoản/mật khẩu không chính xác!!!");
                        break;
                    }
                case 2:
                    try {
                        AccountManager.addAccount();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        AccountManager.removeAccount();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    AccountManager.show();
                    break;
            }
        }
    }
}
