package manager;

import model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static file.readWriteFile.readFileAcc;
import static file.readWriteFile.writeFileAcc;
import static regex.AccountRegex.getAccount;

public class AccountManager {
    static Scanner scanner = new Scanner(System.in);
    public static File file2 = new File("src/Account.txt");
    public static ArrayList<Account> list1 = readFileAcc();

    // tạo tài khoản
    public static void addAccount() throws Exception {
        String account = getAccount();
        System.out.println("Nhập mật khẩu: ");
        String pass = scanner.nextLine();
        String role = getRole1();
        list1.add(new Account(account, pass,role));
        writeFileAcc(file2);
    }
    //============================================
    public static String getRole1(){
        while (true){
            try{
                System.out.println("Bạn là user hay admin?");
                String role = scanner.nextLine();
                if(role.equals("user")||role.equals("admin")){
                    return role;
                }else throw new InterruptedException();

            }catch (InterruptedException e){
                System.out.println("Sai định dạng !!!!");
            }
            catch (Exception e){
                System.out.println("Sai định dạng !!!");
            }
        }
    }

    //Xóa tài khoản
    public static void removeAccount() throws Exception {
        System.out.print("Nhập tên tài khoản bạn muốn xoá: ");
        String acc = scanner.nextLine();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getAcc().equals(acc)) {
                list1.remove(i);
                i--;
            }
        }
        writeFileAcc(file2);
    }

// đặng nhập
    public static int signIn() {
        System.out.print("Nhập tài khoản: ");
        String acc = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String pass = scanner.nextLine();
        for (Account x : list1) {
            if (x.getAcc().equals(acc) && x.getPass().equals(pass)) {
                if(x.getRole().equals("user")){
                    return 1;
                } else return 2;
            }
        }
        return 3;
    }
    public static void show() {
        for (Account x : list1) {
            System.out.println(x.getAcc());
        }
    }
}
