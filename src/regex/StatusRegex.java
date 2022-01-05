package regex;

import java.util.Scanner;

public class StatusRegex extends Exception{
    public static boolean getStatus() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Nhập trạng thái ");
                System.out.println("1.Đang làm việc ");
                System.out.println("2.Đang nghỉ ");
                System.out.print("Nhập lựa chọn của bạn: ");
                int x=Integer.parseInt(scanner.nextLine());
                if (x == 1) {
                    return true;
                }else if(x == 2) {
                    return false;
                }else throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("Sai định dạng !!!");
            }
        }
    }
}
