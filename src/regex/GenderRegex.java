package regex;

import java.util.Scanner;

public class GenderRegex extends Exception{
    static Scanner scanner = new Scanner(System.in);
    @Override
    public String getMessage() {
        return "Sai rồi !!!";
    }
    public static String getGender() {
        while (true) {
            try {
                System.out.print("Nhập giới tính : ");
                String gender = scanner.nextLine();
                if (gender.equals("Male") || gender.equals("Female")) {
                    return gender;
                } else
                    throw new GenderRegex();
            } catch (GenderRegex e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
