package com.streams.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreemExample2 {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(5, "Raj", 10000.00));
        employeeList.add(new Employee(1, "Rajesh", 60000.00));
        employeeList.add(new Employee(4, "Mahesh", 2000.00));
        employeeList.add(new Employee(2, "Ganga", 70000.00));
        employeeList.add(new Employee(3, "Nikhil", 30000.00));
        employeeList.add(new Employee(6, "Sruthi", 7000.00));
       // employeeList.add(new Employee(6, "Keerthi", 9000.00));

        //get all employeeNames
        System.out.println(employeeList.stream().map(e->e.getEmpName()).collect(Collectors.toList()));

        //Map empId as key and Employee as value
        System.out.println(employeeList.stream().collect(Collectors.toMap(e->e.getEmpId(),p->p)));
        //Write a program to print emp name who is getting minimum salary
//      Optional<Employee> minEmp =  employeeList.stream().sorted((o1, o2)-> (int)(o1.getSalary() - o2.getSalary()))
//                .findFirst();
//
//      if(minEmp.isPresent()){
//          System.out.println("Employee with Minimum Salary:"+minEmp);
//      }

        //Write a program to print emp name who is getting Max salary
//        Optional<Employee> maxEmp =  employeeList.stream().sorted((o1, o2)-> (int)(o2.getSalary() - o1.getSalary()))
//                .findFirst();
//
//        if(maxEmp.isPresent()){
//            System.out.println("Employee with Max Salary:"+maxEmp);
//        }

        //using min
        Optional<Employee> minSal = employeeList.stream().min(Comparator.comparingDouble(Employee::getSalary));
        if(minSal.isPresent()){
            System.out.println("EmployeeName with Min Salary:"+minSal.get().getEmpName());
        }

        //using max
        Optional<Employee> maxSal = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        if(minSal.isPresent()){
            System.out.println("EmployeeName with Max Salary:"+maxSal.get().getEmpName());
        }

        //write prograne to convert employee Id into list whos name start with "R"
       List<Integer> employeeIds = employeeList.stream().filter(e->e.getEmpName().startsWith("R"))
                .map(d->d.getEmpId()).sorted()
                .collect(Collectors.toList());
        System.out.println("Employee Ids:"+employeeIds);

        //remove duplicates in employeeList
        employeeList.stream().distinct().forEach(p->System.out.println(p));

        List<Integer> listData = new ArrayList<>();
        listData.add(10);
        listData.add(1);
        listData.add(11);
        listData.add(3);
        listData.add(11);
        listData.add(2);
        listData.add(2);

        listData.stream().distinct().forEach(p->System.out.println(p));



    }
}
