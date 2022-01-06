package regex;

import model.Account;

import static manager.AccountManager.list1;
import static regex.AgeRegex.scanner;

public class AccountRegex {
    public static String getAccount() {
        while (true) {
            try {
                String regex = "^[a-zA-z0-9]\\w*";
                System.out.println("Nhập tên tài khoản: ");
                String acc = scanner.nextLine();
                if(!acc.matches(regex)){
                    throw new IllegalAccessException();
                }
                for (Account account : list1) {
                    if (account.getAcc().equals(acc))
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
}
