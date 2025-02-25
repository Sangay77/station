package com.sangay.ecom.learning.functional.streams;

import java.util.List;

public class SumReduce {

    public static void main(String[] args) {
        List<Integer> numbers=List.of(1,5,7,3,-1);
        int sum=addListFUnctional(numbers);
        System.out.println(sum);
//        int maxmin=MaxMin(numbers);
//        System.out.println(maxmin);

    }

    private static int addListFUnctional(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0,(x,y)->x>y?x:y);
//                .reduce(0,Integer::sum); // using sum method of Integer class
//                .reduce(0,(x,y)->x+y); // lamda expression
//                .reduce(0,SumReduce::sum); //method reference


    }

    private static int sum(int  aggreate, int b) {
        return aggreate+b;
    }

    private static int MaxMin(List<Integer> numbers){

        return numbers.stream()
                .reduce(Integer.MAX_VALUE,(x,y)->x>y?y:x);

    }
}
