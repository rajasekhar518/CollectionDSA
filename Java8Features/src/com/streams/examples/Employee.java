package com.streams.examples;

public class Employee implements Comparable<Employee> {
    private int empId;
    private String empName;
    private double salary;

    public Employee(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        return (this.empId<o.getEmpId())? -1 :((this.empId==o.getEmpId())? 0: 1);
    }

    @Override
    public int hashCode() {
        return empId;
    }

    @Override
    public boolean equals(Object o) {
        Employee e=(Employee)o;
        if(e.getEmpId() == this.empId){
            return true;
        }else{
            return false;
        }

    }
}
