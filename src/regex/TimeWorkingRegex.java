package regex;

import java.util.Scanner;

public class TimeWorkingRegex extends Exception{
    static Scanner scanner = new Scanner(System.in);
    public static int getTimeWorking() {
        while (true) {
            try {
                System.out.print("Nhập số giờ làm việc : ");
                return Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Sai dinh dang");
            }
        }
    }
}
