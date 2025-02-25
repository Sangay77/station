package com.sangay.ecom.learning.functional;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        Function<Integer,String> function=x->x+"x";
        System.out.println(function.apply(10));
    }
}
