package com.sangay.ecom.learning;

import java.util.concurrent.*;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        // Create a cached thread pool
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Submit 5 tasks to the executor
        for (int i = 0; i < 100; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskId + " is running on thread: " + Thread.currentThread().getName());
                try {
                    // Simulating some work
                    Thread.sleep(500000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }


        // Shutdown the executor
        executorService.shutdown();
        System.out.println("HI");

    }
}


