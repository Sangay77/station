//package com.sangay.ecom.learning.Future;
//
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.Executors;
//import java.util.concurrent.RejectedExecutionHandler;
//import java.util.concurrent.TimeUnit;
//
//public class ThreadPoolExecutor {
//
//    private static final RejectedExecutionHandler defaultHandler = new java.util.concurrent.ThreadPoolExecutor.AbortPolicy();
//
//
//    public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
//        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, Executors.defaultThreadFactory(), defaultHandler);
//    }
//
//}
