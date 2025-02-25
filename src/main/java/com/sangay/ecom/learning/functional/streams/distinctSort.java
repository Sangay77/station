package com.sangay.ecom.learning.functional.streams;

import java.util.List;

public class distinctSort {

    public static void main(String[] args) {
        List<Integer> number=List.of(2,1,3,3,5,4);
        Integer reduce = number.stream()
                .distinct() //returns stream
                .sorted() //returns stream
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
