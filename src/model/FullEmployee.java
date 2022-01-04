package model;

import model.Employee;

public class FullEmployee extends Employee {
    public FullEmployee() {
    }

    public FullEmployee(int id, String name, int age, String gender, String phone, String email, boolean status, double salary) {
        super(id, name, age, gender, phone, email, status, salary);
    }

    @Override
    public double totalSalary() {
        return this.getSalary() * 10;
    }

    @Override
    public String toString() {
        return "model.FullEmployee{" + super.toString()+ '}';
    }
}
