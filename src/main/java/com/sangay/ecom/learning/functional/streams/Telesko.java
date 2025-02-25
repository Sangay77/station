package com.sangay.ecom.learning.functional.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Telesko {

    public static void main(String[] args) {

        List<Integer> numbers= Arrays.asList(4,1,2,3);


//        Integer reducescratch = numbers.stream()
//                .filter(x -> x % 2 == 0)
//                .sorted()
//                .map(x -> x * 2)
//                .reduce(0, (x, y) -> x + y);
//        System.out.println(reducescratch);

        Predicate<Integer> evenPredicate=x->x%2==0;
        Function<Integer,Integer> doubleMap=x->x*2;
        BinaryOperator<Integer> sum=(x,y)->x+y;

        oddeven(numbers,evenPredicate);






        Integer reduce = numbers.stream()
                .filter(evenPredicate)
                .sorted()
                .map(doubleMap)
                .reduce(0, sum);
        System.out.println(reduce);


    }

    public static void oddeven(List<Integer> numbers, Predicate<Integer> oddevenPredicate){

        numbers.stream()
                .filter(oddevenPredicate)
                .forEach(System.out::println);
    }
}
