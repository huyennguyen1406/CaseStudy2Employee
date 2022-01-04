package regex;

import manager.EmployeeManager;
import model.Employee;

import java.util.Scanner;

public class IdRegex extends Exception{
    static Scanner scanner = new Scanner(System.in);
    public static boolean checkId(int id) {
        for (Employee employee : EmployeeManager.list) {
            if (employee.getId() == id) {
                return false;
            }
        }
        return true;
    }

    public static int getId() {
        while (true) {
            try {
                System.out.print("Nhập id nhân viên : ");
                int id = Integer.parseInt(scanner.next());
                if (checkId(id) == true) {
                    return id;
                } else throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("Đã tồn tại !!!");
            } catch (Exception e) {
                System.out.println("Sai định dạng !!!");
            }
        }
    }
}
