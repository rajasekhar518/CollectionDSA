package com.streams.examples;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperationsOnMap {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(5, "Raj", 10000.00));
        employeeList.add(new Employee(1, "Rajesh", 60000.00));
        employeeList.add(new Employee(4, "Mahesh", 2000.00));
        employeeList.add(new Employee(2, "Ganga", 70000.00));
        employeeList.add(new Employee(3, "Nikhil", 30000.00));
        employeeList.add(new Employee(6, "Sruthi", 7000.00));

        System.out.println("convert List To Map<Integer,Employee>");
        Map<Integer,Employee> toMap = employeeList.stream().collect(Collectors.toMap(e->e.getEmpId(),e->e));
        System.out.println("convert List To Map<Integer,Employee>:"+toMap);
        System.out.println("Sort Descending by salary the toMap");
        toMap.entrySet().stream()
                .sorted((e1,e2)-> (int)(e2.getValue().getSalary()) - (int)(e1.getValue().getSalary()))
                .forEach(p->System.out.println(p));
        Map<String,Integer> map=new HashMap<>();
        map.put("A",123);
        map.put("E",113);
        map.put("D",133);
        map.put("K",127);
        map.put("G",143);
        map.put("B",110);
        map.put("H",153);

        Set<Map.Entry<String,Integer>> enSet = map.entrySet();
        System.out.println("Sort by keys");
        enSet.stream().sorted((o1,o2)->o1.getKey().compareTo(o2.getKey())).forEach(p->System.out.println(p));
        System.out.println("sort by values");
        enSet.stream().sorted((o1,o2)->o1.getValue()>o2.getValue()? 1: (o1.getValue()==o2.getValue()?0:-1)).forEach(p->System.out.println(p));
    }
}
