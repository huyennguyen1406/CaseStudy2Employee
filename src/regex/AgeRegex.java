package regex;

import java.util.Scanner;

public class AgeRegex extends Exception{
    static Scanner scanner = new Scanner(System.in);
    public static int getAge() {
        while (true) {
            try {
                System.out.print("Nhập tuổi: ");
                int age = Integer.parseInt(scanner.nextLine());
                if (age < 18)
                    throw new AgeRegex();
                else
                    return age;
            } catch (AgeRegex e) {
                System.out.println("Nhỏ hơn 18 tuổi !!!");
            }catch (Exception e){
                System.out.println("Sai định dạng !!!");
            }
        }
    }
}
