package com.sangay.ecom.learning.Future;

public abstract class AbstractExecutorService implements ExecutorService{
    @Override
    public void execute(Runnable runnable) {
        ExecutorService.super.execute(runnable);
    }


}
