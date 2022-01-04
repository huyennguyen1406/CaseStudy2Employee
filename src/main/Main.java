package main;

import manager.AccountManager;
import regex.ChoiceRegex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menuLogin();
    }

    public void menuLogin() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("HỆ THỐNG ĐĂNG NHẬP");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("3. Xóa tài khoản");
            System.out.println("4. Hiển thi tài khoản");
            int choice = ChoiceRegex.getChoice();

            switch (choice) {
                case 1:
                    int choice = AccountManager.signIn();
            }
        }
    }
}
