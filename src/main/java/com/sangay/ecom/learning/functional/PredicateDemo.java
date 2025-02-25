package com.sangay.ecom.learning.functional;

import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {

        Predicate<String> predicateChkLength = text -> text.length() > 5;
        System.out.println(predicateChkLength.test("nokiio"));
    }

}




