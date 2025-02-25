package com.sangay.ecom.learning.functional.streams;

import java.util.List;
import java.util.function.Consumer;

public class methodReference {

    public static void main(String[] args) {

        List<Integer> numbers=List.of(1,2,3,4,5);
        numbers.stream()
                .map(x->x*x)
                .forEach(System.out::println); //returns void
    }

    public static void odd(List<Integer> numbers){

        Consumer<String[]> main = methodReference::main;
        System.out.println(main);

    }
}
