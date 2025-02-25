package com.sangay.ecom.learning.functional.streams;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class BehaviourParameterization {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Predicate<Integer> evenPredicate = x -> x % 2 == 0;
        Predicate<Integer> oddPredicate = x -> x % 2 != 0;
        Function<Integer, Integer> mapFunction = x -> x * x;
        Function<Integer, String> stringmapFunction = x -> x + "sangay";
        BinaryOperator<Integer> binaryOperator = Integer::sum;
        System.out.println(addNum(numbers,binaryOperator));;
        mapandPrint(numbers, mapFunction);
        stringOutputFunction(numbers, stringmapFunction);
        even(numbers,evenPredicate);

        Supplier<Integer> randomIntegerSupplier=()-> {
            Random random=new Random();
            return random.nextInt(100);
        };
        System.out.println(randomIntegerSupplier.get());

        UnaryOperator<Integer> unaryOperator=x->x*3;

        System.out.println(unaryOperator.apply(10));
    }

    private static Integer addNum(List<Integer> numbers, BinaryOperator<Integer> operator) {

        return numbers.stream()
                .reduce(0,operator);

    }

    private static void stringOutputFunction(List<Integer> numbers, Function<Integer,String> func) {
        numbers.stream()
                .map(func)
                .forEach(System.out::println);
    }

    private static void mapandPrint(List<Integer> numbers, Function<Integer,Integer> function) {

        numbers.stream()
                .map(function)
                .forEach(System.out::println);
    }

    private static void even(List<Integer> numbers, Predicate<Integer> predicate){
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }



}
