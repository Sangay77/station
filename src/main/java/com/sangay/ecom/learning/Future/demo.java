package com.sangay.ecom.learning.Future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Future<List<Integer>> future1=executorService.submit(()->{
            System.out.println(Thread.currentThread().getName());
            return Arrays.asList(1,2,3,4,5);
        });

        Future<List<Integer>> future2=executorService.submit(()->{
            System.out.println(Thread.currentThread().getName());
            return Arrays.asList(1,2,3,4,5);
        });

        Future<List<Integer>> future3=executorService.submit(()->{
            System.out.println(Thread.currentThread().getName());
            return Arrays.asList(1,2,3,4,5);
        });

        List<Integer> list=future1.get();
        System.out.println(list);
    }
}
