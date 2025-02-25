package com.sangay.ecom.learning.functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class funcdemo {

    public static void main(String[] args) {

        List<Integer> numbers=List.of(1,2,3,4,5);
        numbers.stream()
                .map(x->x*x) //lamda expression
                .forEach(System.out::println); //Method Reference

        List<String> courses = List.of("spring","spring boot","API","Microservices","AWS","PCF","Azure","Docker","kubernates");
        courses.stream()
                .filter(course->course.contains("spring"))
                .forEach(System.out::println);

    }


}

