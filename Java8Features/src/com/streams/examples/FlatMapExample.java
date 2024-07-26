package com.streams.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<String> al1 = new ArrayList<>();
        al1.add("A");
        al1.add("B");
        al1.add("C");

        List<String> al2= new ArrayList<>();
        al2.add("E");
        al2.add("F");
        al2.add("G");

        List<List<String>> al3=new ArrayList<>();
        al3.add(al1);
        al3.add(al2);

        //System.out.println(al3);

        //convert List<List<String> to List<String>
        //before Java8
        List<String> finalList= new ArrayList<>();
        for (int i = 0; i <al3.size() ; i++) {
            List<String> resultList = al3.get(i);
            for (int j = 0; j <resultList.size() ; j++) {
                String s = resultList.get(j);
                finalList.add(s);
            }
        }
        System.out.println("Before Java 8:"+finalList);
       // System.out.println(al3.stream().flatMap(a->a.stream()).collect(Collectors.toList()));
        List<String> al4 = al3.stream().flatMap(a->a.stream()).collect(Collectors.toList());
        System.out.println("Before Java 8:"+al4);

    }
}
