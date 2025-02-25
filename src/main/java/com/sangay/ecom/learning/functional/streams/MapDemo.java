package com.sangay.ecom.learning.functional.streams;

import com.mysql.cj.util.StringUtils;

import java.util.List;

public class MapDemo {

    public static void main(String[] args) {
        List<Integer> numbers=List.of(1,2,3,4);

        numbers.stream()
                .reduce(0,(accumulator,current)->accumulator+current);


        List<String> names=List.of("sangay", "Tenzin@l","NOKO");
        names.stream()
                .map(StringUtils::urlEncode)
                .forEach(System.out::println);

    }




}
