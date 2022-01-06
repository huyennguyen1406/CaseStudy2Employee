package manager;

import model.Account;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
public class AccountManager {
    static Scanner scanner = new Scanner(System.in);
    static File file2 = new File("src/Account.txt");
    static ArrayList<Account> list1 = docFileAcc();

    //ghi file
    public static void ghiFileAcc(File file) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (Account pp : list1) {
                bufferedWriter.write(pp.ghi1());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
        }
    }

    //đọc file
    public static ArrayList<Account> docFileAcc() {
        ArrayList<Account> list2 = new ArrayList<>();
        try {
//            if(!file2.exists()){
//                file2.createNewFile();
//            }
            FileReader fileReader = new FileReader(file2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(",");
                if (str.length >= 3) {
                    list2.add(new Account(str[0], str[1],str[2]));
                }
            }
//
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list2;
    }

    // tạo tài khoản
    public static void addAccount() throws Exception {
        String account = getAccount();
        System.out.println("Nhập mật khẩu: ");
        String pass = scanner.nextLine();
        String role=getRole1();
        list1.add(new Account(account, pass,role));
        ghiFileAcc(file2);
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

    //    ==============================
    private static String getAccount() {
        while (true) {
            try {
                String regex = "^[a-zA-z0-9]\\w*";
                System.out.println("Nhập tên tài khoản: ");
                String acc = scanner.nextLine();
                if(!acc.matches(regex)){
                    throw new IllegalAccessException();
                }
                for (Account employee : list1) {
                    if (employee.getAcc().equals(acc))
                        throw new InterruptedException();
                }
                return acc;
            } catch (InterruptedException e) {
                System.out.println("Đã tồn tại ");
            }catch (IllegalAccessException e){
                System.out.println("Lỗi !!!");
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
        ghiFileAcc(file2);
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
