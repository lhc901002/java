package org.michaelliu.java.thread.guava;

import com.google.common.util.concurrent.*;
import org.michaelliu.java.thread.SumTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Michael on 2016/7/17.
 */
public class ListenableFutureDemo {

    public static void main(String[] args) {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        final ListenableFuture<Long> listenableFuture = executorService.submit(new SumTask(new AtomicLong(0)));
        // Method 1 for receiving the result of Callable task
        listenableFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("get listenable future's result " + listenableFuture.get());
                } catch (InterruptedException e) {
                    System.err.println(e);
                } catch (ExecutionException e) {
                    System.err.println(e);
                }
            }
        }, executorService);

        // Method 2 for receiving the result of Callable task
        Futures.addCallback(listenableFuture, new FutureCallback<Long>() {
            @Override
            public void onSuccess(Long result) {
                System.out.println("get listenable future's result with callback " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.err.println(t);
            }
        });

        executorService.shutdown();
    }

}
