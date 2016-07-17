package org.michaelliu.java.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Michael on 2016/7/17.
 *
 * get the result of each thread using Callable+Future
 */
public class RunSumTask implements Callable<Long> {

    /**
     * @return result of the increment after all threads complete
     * @throws Exception
     */
    @Override
    public Long call() throws Exception {
        AtomicLong number = new AtomicLong(0);
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            Future<Long> result = executor.submit(new SumTask(number));
            System.out.println(result.get());
        }
        executor.shutdown();
        return number.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Long> result = executor.submit(new RunSumTask());
        executor.shutdown();
        System.out.println(result.get());
    }

}
