package com.streams.examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StreamExample3 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(5, "Raj", 10000.00));
        employeeList.add(new Employee(1, "Rajesh", 60000.00));
        employeeList.add(new Employee(4, "Mahesh", 2000.00));
        employeeList.add(new Employee(2, "Ganga", 70000.00));
        employeeList.add(new Employee(3, "Nikhil", 30000.00));
        employeeList.add(new Employee(6, "Sruthi", 7000.00));

        //print second Highest Salary of Employee
        employeeList.stream().sorted((s1,s2)->s1.getSalary()<s2.getSalary()?-1 : ((s1.getSalary()==s2.getSalary()? 0 : 1)))
                .limit(5).skip(4).forEach(System.out::println);

        //print Third Highest Salary of Employee
        employeeList.stream().sorted((s1,s2)-> (int)(s1.getSalary() - s2.getSalary())).limit(4).skip(3)
                .forEach(System.out::println);

        List<Integer> listData = new ArrayList<>();
        listData.add(10);
        listData.add(1);
        listData.add(11);
        listData.add(3);
        listData.add(2);
        listData.stream().sorted().distinct().limit(4).skip(3).forEach(System.out::println);
        System.out.println("Limit doen't work for unordered list");
        Set<Integer> setData = new HashSet<>();
        setData.add(1);
        setData.add(8);
        setData.add(10);
        setData.add(9);
        setData.add(4);
        //setData.stream().limit(4).forEach(p->System.out.println(p));

        System.out.println("convert set to list and use limit");

        List<Integer> convertList = new ArrayList<>(setData);
        convertList.stream().limit(4).forEach(p->System.out.println(p));

        //print true or EmployeeName if at lease one employee start with "R"
        employeeList.stream().filter(e->e.getEmpName().startsWith("R")).findFirst().ifPresent(p->System.out.println(p));

        //anyMatch return boolean if condtion is match return true.Not match return false
        System.out.println(employeeList.stream().anyMatch(e->e.getEmpName().startsWith("A")));

        //The allMatch method returns true if every element in the stream matches the given predicate.
        //If any single element fails to match the predicate, allMatch will return false.
        System.out.println(employeeList.stream().allMatch(e->e.getEmpName().startsWith("R")));
        //If every element fails the predicate, noneMatch returns true.
        // If at least one element satisfies the predicate, noneMatch returns false.
        //noneMatch is the opposite of anyMatch. If anyMatch checks for the presence of at least one element satisfying the condition,
        // noneMatch checks for the absence of elements satisfying the condition.
        System.out.println(employeeList.stream().noneMatch(e->e.getEmpName().startsWith("R")));
        //The findFirst method retrieves the first element from a stream
        //The findAny method retrieves any element from the stream
        employeeList.stream().filter(e->e.getEmpName().startsWith("R")).findAny().ifPresent(p->System.out.println(p));


    }
}
