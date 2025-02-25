package com.sangay.ecom.learning.functional.streams;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class howitworks {

    public static void main(String[] args) {

        List<Integer> list=List.of(1,2,3,4);

        Predicate<Integer> integerPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer num) {
                return num%2==0;
            }
        };
        Function<Integer, Integer> integerIntegerFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        Consumer<Integer> println = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };
        list.stream()
                .filter(integerPredicate)
                .map(integerIntegerFunction)
                .forEach(println);

        BinaryOperator<Integer> sum1 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a+b ;
            }
        };

        int sum=list.stream()
                .reduce(0, sum1);
        System.out.println(sum);
    }
}
