package regex;

import manager.EmployeeManager;
import model.Employee;

public class EmailRegex extends Exception{

    public static boolean checkEmail(String email){
        String str1 = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        return email.matches(str1);
    }

    public static boolean checkEmail1(String email){
        for (Employee employee : EmployeeManager.list) {
            if (employee.getEmail().equals(email))
                return true;
        }
        return false;
    }
    public static String getEmail() {
        while (true) {
            try {
                System.out.print("Nhập email: ");
                String email = EmployeeManager.scanner.next();
                if(checkEmail(email)){
                    if(!checkEmail1(email)){
                        return email;
                    }else throw new InterruptedException();

                }else {
                    throw new EmailRegex();
                }
            } catch (EmailRegex e) {
                System.out.println(e.getMessage());
            }
            catch (InterruptedException e){
                System.out.println("Đã tồn tại!!!");
            }
        }
    }
    @Override
    public String getMessage(){
        return "Sai định dạng!!!";
    }
}
