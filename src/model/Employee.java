package model;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String email;
    private boolean status;
    private int salary;
    private double totalSalary;

    public Employee() {
    }

    public Employee(int id, String name, int age, String gender, String phone, String email, boolean status, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getSalary() {
        return salary;
    }

    public double totalSalary() {
        return totalSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String write(){
        return id + "," + name + "," + age + "," + gender + "," + phone+ "," + email + "," + status + "," + salary;
    }
}
