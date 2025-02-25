//package com.sangay.ecom.learning.Future;
//
//import java.util.concurrent.*;
//
//public class SquareCalculator {
//
//    ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//    public Future<Integer> calculateSquare(int number) {
//        return executorService.submit(() -> {
//            Thread.sleep(1000);
//            return number * number;
//        });
//    }
//}
//
//class calculator {
//    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        Future<Integer> FutureSum = new SquareCalculator().calculateSquare(3);
//        while (!FutureSum.isDone()) {
//            System.out.println("Calculating ...");
//            Thread.sleep(1000);
//        }
//        Integer result = FutureSum.get(10, TimeUnit.MILLISECONDS);
//        System.out.println(result);
//        System.out.println("HI");
//    }
//}
//
//class calculator2 {
//    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//
//        SquareCalculator squareCalculator = new SquareCalculator();
//
//        Future<Integer> future1 = squareCalculator.calculateSquare(10);
//        Future<Integer> future2 = squareCalculator.calculateSquare(100);
//
//        while (!(future1.isDone() && future2.isDone())) {
//            System.out.println(
//                    String.format(
//                            "future1 is %s and future2 is %s",
//                            future1.isDone() ? "done" : "not done",
//                            future2.isDone() ? "done" : "not done"
//                    )
//            );
//            Thread.sleep(300);
//        }
//
//        Integer result1 = future1.get();
//        Integer result2 = future2.get();
//        System.out.println("noko");
//
//        System.out.println(result1 + " and " + result2);
//
//    }
//}
