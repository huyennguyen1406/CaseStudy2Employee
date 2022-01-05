package manager;

import model.Employee;
import model.FullEmployee;
import model.PartEmployee;
import regex.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static manager.FileManager.docFile;
import static manager.FileManager.ghiFile;

public class EmployeeManager {
    public static Scanner scanner = new Scanner(System.in);

    static File file1 = new File("./src/CaseStudy/Employee.txt");
    public static ArrayList<Employee> list = docFile();
    public static void addEmployee() throws IOException {
        System.out.println("Thêm nhân viên ");
        System.out.println("1.Nhân viên Parttime ");
        System.out.println("2.Nhân viên Fulltime  ");
        System.out.println("3.Exit");
        System.out.print("Enter your choice ");
        int x = Integer.parseInt(scanner.nextLine());
        switch (x) {
            case 1:
                list.add(addPartEmployee());
                ghiFile(file1);
                break;
            case 2:

                list.add(addFullEmployee());
                ghiFile(file1);
                break;
        }
    }

    //=====================================================
    public static Employee addPartEmployee() {
        System.out.print("Nhập tên : ");
        String name = scanner.nextLine();
        return new PartEmployee(IdRegex.getId(), name, AgeRegex.getAge(), GenderRegex.getGender(), PhoneRegex.getPhone(), EmailRegex.getEmail(), StatusRegex.getStatus(), SalaryRegex.getSalary(), TimeWorkingRegex.getTimeWorking());
    }
    public static Employee addFullEmployee() {
        System.out.print("Nhập tên : ");
        String name = scanner.nextLine();
        return new FullEmployee(IdRegex.getId(), name, AgeRegex.getAge(), GenderRegex.getGender(), PhoneRegex.getPhone(), EmailRegex.getEmail(), StatusRegex.getStatus(), SalaryRegex.getSalary());
    }
    //================================================
    public static void removeEmployee() throws Exception {
        System.out.print(" Nhập id bạn muốn xoá  : ");
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
        ghiFile(file1);
    }

    //===============================================
    public static void changeInfo() throws Exception {
        System.out.print("Nhập id bạn muốn sửa : ");
        int id = Integer.parseInt(scanner.nextLine());
        int index=-1;
        System.out.println("=======================//Nhập thông tin bạn muốn sửa//============================");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index=i;
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
        ghiFile(file1);
    }

    //===============================================
    public static void checkInfo() {
        System.out.println("Nhập id bạn muốn kiểm tra");
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

    //=====================================================
    public static void changeStatus() throws Exception {
        System.out.println("Nhập id bạn muốn thay đổi");
        int id = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
                if (StatusRegex.getStatus() == true) {
                    list.get(i).setStatus(false);
                    System.out.println("Nhân viên có id " + id + "đang nghỉ.");
                } else {
                    list.get(i).setStatus(true);
                    System.out.println("Nhân viên có id" + id + " đang làm việc.");
                }
                System.out.println("Đã thay đổi thành công !!!");
            }
        }
        if (index == -1) {
            System.out.println("Không tồn tại id này!!!");
        }
        ghiFile(file1);
    }
    //=====================================================
    public static void showSalary(){
        System.out.print("Nhập id bạn muốn hiển thị lương: ");
        int id = Integer.parseInt(scanner.next());
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
                System.out.print("Lương của nhân viên là : ");
                System.out.println(list.get(i).totalSalary());
            }
        }
        if(index == -1){
            System.out.println("Không tồn tại id này !!!");
        }
    }
    //=====================================================
    public static void sort() throws Exception{
        list.sort(Comparator.comparing(o -> ((Employee) o).getId()));
        ghiFile(file1);
    }
    //=======================================================
    public static void findByName(){
        System.out.println("Nhập tên bạn muốn tìm kiếm ");
        String name=scanner.nextLine();
        for(Employee tr:list){
            if( tr.getName().contains(name)){
                System.out.println(tr);
            }
        }
    }
    public static void show() {
        for(Employee x:list){
            System.out.println(x);
        }
    }
    public static void show1() {
        int index = -1;
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).toString().contains("FullEmployee")) {
                index = i;
                System.out.println(list.get(i).toString());
            }
        }
        if(index == -1){
            System.out.println("Không có nhân viên Full time nào !!!");
        }
    }

    public static void show2() {
        int index = -1;
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).toString().contains("PartEmployee")) {
                index = i;
                System.out.println(list.get(i).toString());
            }
        }
        if(index == -1){
            System.out.println("Không có nhân viên PartTime nào !!!");
        }
    }
}
