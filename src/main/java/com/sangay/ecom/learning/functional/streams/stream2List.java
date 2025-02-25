package com.sangay.ecom.learning.functional.streams;

import java.util.List;
import java.util.stream.Collectors;

public class stream2List {

    public static void main(String[] args) {

        List<Integer> num=List.of(1,2,3,4);
        even(num);
    }

    private static void even(List<Integer> num) {

        List<Integer> list = num.stream()
                .map(x -> x * x)
                .toList();
        System.out.println(list);

    }
}
