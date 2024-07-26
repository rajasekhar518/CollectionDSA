package com.streams.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SteramExample1 {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(5, "Raj", 10000.00));
        employeeList.add(new Employee(1, "Rajesh", 60000.00));
        employeeList.add(new Employee(4, "Mahesh", 2000.00));
        employeeList.add(new Employee(2, "Ganga", 70000.00));
        employeeList.add(new Employee(3, "Nikhil", 30000.00));
        employeeList.add(new Employee(6, "Sruthi", 7000.00));

        //sort employee before Java7
        System.out.println("Before Java8 Sort");
        //Collections.sort(employeeList);
        //System.out.println("Employee Sort By Comparable:"+employeeList);
        System.out.println("***************");

        System.out.println("Sort By Comparator before Java8");
//        Collections.sort(employeeList, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getEmpName().compareTo(o2.getEmpName());
//            }
//        });

//        Comparator<Employee> sortByEmpName = (o1,o2)->{
//            return o1.getEmpName().compareTo(o2.getEmpName());
//        };
        Comparator<Employee> sortByEmpName = Comparator.comparing( e->e.getEmpName());

       Collections.sort(employeeList,sortByEmpName);
//        Collections.sort(employeeList,(o1, o2)->{
//            return o1.getEmpName().compareTo(o2.getEmpName());
//        });
        System.out.println("Employee Sort By Name:"+employeeList);
        System.out.println("Sort Using java8");
       List<Employee> sortBySal =  employeeList.stream()
               .sorted((o1,o2)-> (int) (o1.getSalary() - o2.getSalary()))
               .collect(Collectors.toList());
//       List<Employee> soretByEmp = employeeList.stream().sorted((o1,o2)-> o1.getEmpName().compareTo(o2.getEmpName()))
//                .collect(Collectors.toList());

        System.out.println("Employee Sort By Salary java8 :"+sortBySal);

        Predicate<Employee> p2=(e)->{
            if(e.getEmpName().startsWith("R")){
                return true;
            }else{
                return false;
            }
        };

        Predicate<Employee> p=(e)->{
            return e.getEmpName().startsWith("R");
        };

        Predicate<Employee> p1=(e)->e.getEmpName().startsWith("R");
       // employeeList.stream().filter(p1).forEach(e->System.out.println(e.getEmpName()));
        employeeList.stream().filter((e)->e.getEmpName().startsWith("R"))
                .forEach(e->System.out.println(e.getEmpName()));

        employeeList.stream().map((e)->e.getSalary()).forEach(e->System.out.println(e));
        //sort emp start with "R"
        for (int i = 0; i < employeeList.size(); i++) {
            if (ValidateEmpNames(employeeList.get(i).getEmpName())) {
                System.out.println("EmpNames start with 'R' :" + employeeList.get(i).getEmpName());
            }
        }

        //print all salary of employees
        for (Employee e:employeeList) {
           double salEmpl = printEmpSalary(e);
           System.out.println(salEmpl);
        }

    }
    static boolean ValidateEmpNames(String employeeName){
        if(employeeName.startsWith("R")){
            return true;
        }else{
            return false;
        }
    }

    static double printEmpSalary(Employee e){
      return e.getSalary();
    }
}
