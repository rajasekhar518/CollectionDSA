package com.streams.examples;

import java.util.Optional;

public class OptionalExample {

    //of method throws NullPointer Exeption.
    //ofNullable not throws NullpointerExeption it returns empty.
    public static void main(String[] args) {

        Optional<String> s2=m1();
       // s2.ifPresent(s->System.out.println(s));
        s2.ifPresentOrElse(s-> {
                    if (s.startsWith("R")) {
                        System.out.println("Hello");
                    } else {
                        System.out.println("Hi");
                    }
                },
            ()->System.out.println("No Exception")

        );
//        if(s2.isPresent()){
//            if(s2.get().startsWith("R")){
//                System.out.println("Hello");
//            }else {
//                System.out.println("Hi");
//            }
//        }else{
//            System.out.println("No Exception");
//        }
       // String s= m1();
//        if(s.startsWith("R")){
//            System.out.println("Hello");
//        }else{
//            System.out.println("Hello");
//        }
    }


    private static Optional<String> m1() {
        //Optional<String> op= Optional.of(null);
        Optional<String> op1= Optional.ofNullable(null);
        //Optional<String> op2= Optional.ofNullable("Raju");
        return op1;
    }
}
