package com.sangay.ecom.learning.functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Animal {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello" + " From " + Thread.currentThread().getName());

        IntStream.range(0,500)
                .forEach(i->{
                   Thread thread=new Thread(new cat());
                   thread.start();
                });

        Dog dog = new Dog();
        dog.start();



    }
}

class Dog extends Thread {

    @Override
    public void run() {

        List<Integer> lists = Arrays.asList(1, 2, 3, 4, 5, 6);

        for (int i : lists) {
            System.out.println(i + " From " + Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class cat implements Runnable {

    @Override
    public void run() {

        try {
            Thread.sleep(10000);
            System.out.println("After sleep" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class CpuIntensivePrimeCalculator  implements Runnable{

    private int count;

    public CpuIntensivePrimeCalculator(int n){
        this.count=n;
    }


    @Override
    public void run() {



    }
}


