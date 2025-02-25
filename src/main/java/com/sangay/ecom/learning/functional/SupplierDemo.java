package com.sangay.ecom.learning.functional;

import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {

        Supplier<Double> doubleSupplier= Math::random;
        System.out.println(doubleSupplier.get());
    }
}
