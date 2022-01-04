package regex;

import manager.EmployeeManager;
import model.Employee;

import java.util.Scanner;

public class PhoneRegex extends Exception{
    static Scanner scanner = new Scanner(System.in);
    public static boolean checkPhone(String phone) {
        String str1 = "0[3-9]{1}\\d{8}";
        if (phone.matches(str1)) {
            return true;
        } else return false;
    }

    public static boolean checkPhone1(String phone) {
        for (Employee employee : EmployeeManager.list) {
            if (employee.getPhone() == phone)
                return false;
        }
        return true;
    }

    public static String getPhone() {
        while (true) {
            try {
                System.out.print("Nhập số điện thoại: ");
                String phone = scanner.nextLine();
                if (checkPhone(phone) == true) {
                    if (checkPhone1(phone) == true) {
                        return phone;
                    } else throw new InterruptedException();
                }else throw new IllegalAccessException();
            } catch (InterruptedException e) {
                System.out.println("Đã tồn tại !!!");
            }catch (IllegalAccessException e){
                System.out.println("Sai định dạng !!!");
            }
        }
    }

    public static void main(String[] args) {
        getPhone();
    }
}
