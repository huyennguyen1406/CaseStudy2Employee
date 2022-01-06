package regex;

import java.util.Scanner;

public class ChoiceRegex extends Exception{
    static Scanner scanner = new Scanner(System.in);
    public static int getChoice(){
        while (true){
            try{
                System.out.print("Nhập lựa chọn của bạn: ");
                return Integer.parseInt(scanner.next());
            }catch (Exception e){
                System.out.println("Sai định dạng");
            }
        }
    }
}
