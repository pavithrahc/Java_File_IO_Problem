package com.bridgelabz;

public class EmployeePayRoleData {
    int employeeId;
    String employeeName;
    double employeeSalary;

    public EmployeePayRoleData(Integer id, String name, Double salary) {

        this.employeeId = id;
        this.employeeName = name;
        this.employeeSalary = salary;
    }

    @Override
    public String toString() {

        return "Employee Details: \nEmployee Id: "+employeeId+"\nEmployee Name: "+employeeName+"\nEmployee Salary: "+employeeSalary;
    }
}

