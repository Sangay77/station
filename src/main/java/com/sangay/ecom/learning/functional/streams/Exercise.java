package com.sangay.ecom.learning.functional.streams;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public class Exercise {

    public static void main(String[] args) {

        List<String> courses=List.of("java","python","PHP", "MATH");
        getcourses(courses);

        List<Integer> numbers=List.of(1,2,3,4,5);
        getcubes(numbers);

        calculate(numbers);
        addOdd(numbers);
    }

    public static void getcourses(List<String> courses){

         courses.stream()
                .filter(x->x.length()>=4)
                 .forEach(System.out::println); //method reference
    }

    public static void getcubes(List<Integer> numbers){

        numbers.stream()
                .filter(x->x%2==0)
                .map(x->x*x*x)
                .forEach(System.out::println);
    }
    public static void calculate(List<Integer> num){
        Integer reduce = num.stream()
                .reduce(0, (x, y) -> x * x + y * y);
        System.out.println(reduce);
    }
    public static void addOdd(List<Integer> num){
        Integer reduce = num.stream()
                .filter(x->x%2==1)
                .reduce(0,Integer::sum); // method refernce or lamda expression
//                .reduce(0,(x,y)->x+y);
        System.out.println(reduce);
    }
}
