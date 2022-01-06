package file;

import model.Account;
import model.Employee;
import model.FullEmployee;
import model.PartEmployee;

import java.io.*;
import java.util.ArrayList;

import static manager.AccountManager.file2;
import static manager.AccountManager.list1;
import static manager.EmployeeManager.file1;
import static manager.EmployeeManager.list;

public class readWriteFile extends Exception{

    public static void writeFileAcc(File file) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (Account pp : list1) {
                bufferedWriter.write(pp.write1());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert bufferedWriter != null;
            bufferedWriter.close();
        }
    }

    //đọc file acc
    public static ArrayList<Account> readFileAcc() {
        ArrayList<Account> list2 = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(",");
                if (str.length >= 3) {
                    list2.add(new Account(str[0], str[1],str[2]));
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list2;
    }
//đọc file employee
    public static ArrayList<Employee> readFile() {
        ArrayList<Employee> list1 = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file1);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(",");
                if (str.length == 9) {
                    list1.add(new PartEmployee(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]), str[3], str[4], str[5], Boolean.parseBoolean(str[6]), Integer.parseInt(str[7]),Integer.parseInt(str[8])));
                }else if (str.length == 8) {
//                    int id,String name, int age, String gender, String phone, String email,boolean status, double salary
                    list1.add(new FullEmployee(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]), str[3], str[4], str[5], Boolean.parseBoolean(str[6]), Integer.parseInt(str[7])));
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list1;
    }
//ghi file employee
    public static void writeFile(File file) throws IOException {
        BufferedWriter bufferedWriter = null;

        try {
            FileWriter fileWriter = new FileWriter(file, false);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (Employee pp : list) {
                bufferedWriter.write(pp.write());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert bufferedWriter != null;
            bufferedWriter.close();
        }
    }
}
