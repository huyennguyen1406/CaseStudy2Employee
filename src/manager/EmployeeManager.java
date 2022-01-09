package manager;

import model.Employee;
import model.FullEmployee;
import model.PartEmployee;
import regex.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static file.readWriteFile.readFile;
import static file.readWriteFile.writeFile;

public class EmployeeManager {
    public static Scanner scanner = new Scanner(System.in);

    public static File file1 = new File("src/file/Employee.txt");
    public static ArrayList<Employee> list = readFile();
    public static void addEmployee() throws IOException {
        System.out.println("Thêm nhân viên ");
        System.out.println("1.Nhân viên Fulltime ");
        System.out.println("2.Nhân viên Parttime ");
        System.out.println("3.Exit");
        System.out.print("Nhập lựa chọn của bạn: ");
        int x = Integer.parseInt(scanner.nextLine());
        switch (x) {
            case 1:
                list.add(addFullEmployee());
                writeFile(file1);
                break;
            case 2:
                list.add(addPartEmployee());
                writeFile(file1);
                break;
        }
    }
    //thêm nhân viên
    public static Employee addPartEmployee() {
        System.out.print("Nhập tên nhân viên Parttime: ");
        String name = scanner.nextLine();
        return new PartEmployee(IdRegex.getId(), name, AgeRegex.getAge(), GenderRegex.getGender(), PhoneRegex.getPhone(), EmailRegex.getEmail(), StatusRegex.getStatus(), SalaryRegex.getSalary(), TimeWorkingRegex.getTimeWorking());
    }
    public static Employee addFullEmployee() {
        System.out.print("Nhập tên nhân viên Fulltime: ");
        String name = scanner.nextLine();
        return new FullEmployee(IdRegex.getId(), name, AgeRegex.getAge(), GenderRegex.getGender(), PhoneRegex.getPhone(), EmailRegex.getEmail(), StatusRegex.getStatus(), SalaryRegex.getSalary());
    }

    //xóa nhân viên
    public static void removeEmployee() throws Exception {
        System.out.print("Nhập ID bạn muốn xoá: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
                list.remove(i);
                i--;
            }
        }
        if (index == -1) {
            System.out.println("Không tồn tại id này!!!");
        }
        writeFile(file1);
    }

    //thay đổi thông tin nhân viên
    public static void changeInfo() throws Exception {
        System.out.print("Nhập id bạn muốn sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = -1;
        System.out.println("Nhập thông tin bạn muốn sửa: ");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
                if (list.get(i) instanceof PartEmployee) {
                    list.remove(i);
                    list.add(i, addPartEmployee());
                    break;
                } else {
                    list.remove(i);
                    list.add(i, addFullEmployee());
                    break;
                }
            }
        }
        if(index == -1){
            System.out.println("Không tồn tại id này !!!");
        }
        writeFile(file1);
    }

    //kiểm tra thông tin nhân viên
    public static void checkInfo() {
        System.out.println("Nhập id bạn muốn kiểm tra: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
                System.out.println(list.get(i).toString());
            }
        }
        if (index == -1) {
            System.out.println("Không tồn tại id này!!!");
        }
    }

    //thay đổi trạng thái
    public static void changeStatus() throws Exception {
        System.out.println("Nhập id bạn muốn thay đổi: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
                if (StatusRegex.getStatus()) {
                    list.get(i).setStatus(true);
                    System.out.println("Nhân viên có id " + id + " đang làm việc.");
                } else {
                    list.get(i).setStatus(false);
                    System.out.println("Nhân viên có id " + id + " đang nghỉ.");
                }
                System.out.println("Đã thay đổi thành công !!!");
            }
        }
        if (index == -1) {
            System.out.println("Không tồn tại id này!!!");
        }
        writeFile(file1);
    }
    //show lương
    public static void showSalary(){
        System.out.print("Nhập id bạn muốn hiển thị lương: ");
        int id = Integer.parseInt(scanner.next());
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
                System.out.print("Lương của nhân viên là: ");
                System.out.println(list.get(i).totalSalary());
            }
        }
        if(index == -1){
            System.out.println("Không tồn tại id này!!!");
        }
    }
    //sắp xếp nhân viên
    public static void sortAge() {
        list.sort(Comparator.comparingInt(Employee::getAge));
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    //tìm nhân viên theo tên
    public static void findByName(){
        System.out.println("Nhập tên bạn muốn tìm kiếm: ");
        String name = scanner.nextLine();
        for(Employee employee : list){
            if( employee.getName().contains(name)){
                System.out.println(employee);
            }
        }
    }

    //hiển thị nhân viên
    public static void show() {
        for(Employee employee : list){
            System.out.println(employee);
        }
    }
    public static void showFull() {
        int index = -1;
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).toString().contains("FullEmployee")) {
                index = i;
                System.out.println(list.get(i).toString());
            }
        }
        if(index == -1){
            System.out.println("Không có nhân viên Fulltime nào!!!");
        }
    }

    public static void showPart() {
        int index = -1;
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).toString().contains("PartEmployee")) {
                index = i;
                System.out.println(list.get(i).toString());
            }
        }
        if(index == -1){
            System.out.println("Không có nhân viên Parttime nào!!!");
        }
    }
}
