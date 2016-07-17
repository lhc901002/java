package org.michaelliu.java.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Michael on 2016/7/17.
 *
 * get the result of each thread using Callable+FutureTask
 */
public class RunSumTask2 implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        AtomicLong number = new AtomicLong(0);
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            FutureTask<Long> futureTask = new FutureTask<>(new SumTask(number));
            executor.submit(futureTask);
            System.out.println(futureTask.get());
        }
        executor.shutdown();
        return number.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<Long> futureTask = new FutureTask<>(new RunSumTask());
        executor.submit(futureTask);
        executor.shutdown();
        System.out.println(futureTask.get());
    }

}
