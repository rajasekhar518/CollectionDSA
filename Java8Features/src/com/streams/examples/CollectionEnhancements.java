package com.streams.examples;

import java.util.ArrayList;
import java.util.List;

public class CollectionEnhancements {
    public static void main(String[] args) {
        List<String> al=new ArrayList<>();
        al.add("Mahesh");
        al.add("Raju");
        al.add("Rakesh");
        al.add("Raju");
        al.add("Ganga");

       //System.out.println(al.remove("Raju"));
        System.out.println(al.removeIf(p->p.equals("Raju")));
        System.out.println(al);


    }
}
