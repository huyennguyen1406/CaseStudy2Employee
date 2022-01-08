package regex;

import java.util.Scanner;

public class SalaryRegex extends Exception{
    static Scanner scanner = new Scanner(System.in);
    public static int getSalary(){
        while (true){
            try{
                System.out.print("Nhập lương của nhân viên: ");
                return Integer.parseInt(scanner.next());
            }catch (Exception e){
                System.out.println("Sai định dạng!!!");
            }
        }
    }
}
