package com.sangay.ecom.learning;

public class SystemInfo {
    public static void main(String[] args) {
        // Print system information
        System.out.println("Operating System: " + System.getProperty("os.name"));
        System.out.println("OS Architecture: " + System.getProperty("os.arch"));
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Free Memory (in bytes): " + Runtime.getRuntime().freeMemory());
        System.out.println("Total Memory (in bytes): " + Runtime.getRuntime().totalMemory());
        System.out.println("Max Memory (in bytes): " + Runtime.getRuntime().maxMemory());

        // Thread information
        System.out.println("Current Thread: " + Thread.currentThread().getName());
    }
}
