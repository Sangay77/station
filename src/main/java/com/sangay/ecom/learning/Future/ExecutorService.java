package com.sangay.ecom.learning.Future;

public interface ExecutorService extends Executor{

    @Override
    default void execute(Runnable runnable) {

    }
}
