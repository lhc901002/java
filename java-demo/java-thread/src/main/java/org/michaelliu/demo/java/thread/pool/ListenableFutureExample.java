package org.michaelliu.demo.java.thread.pool;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import javafx.util.Pair;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.demo.java.thread.CountThread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by michael on 2016/7/23.
 */
public class ListenableFutureExample {

    private static Log log = LogFactory.getLog(ThreadPoolExample.class);

    private List<CountThread> countThreadList;

    private List<CountThread> failedThreadList;

    public ListenableFutureExample(int threadNum) {
        countThreadList = Lists.newArrayList();
        for (int i = 1; i <= threadNum; i++) {
            countThreadList.add(new CountThread(i));
        }
        failedThreadList = Lists.newArrayList();
    }

    public void useFixedThreadPool(int size) {
        ExecutorService executor = Executors.newFixedThreadPool(size);
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);
        for (CountThread thread : countThreadList) {
            final ListenableFuture<Pair<CountThread, Long>> listenableFuture = executorService.submit(thread);
            listenableFuture.addListener(new Runnable() {
                @Override
                public void run() {
                    Pair<CountThread, Long> resultPair = null;
                    try {
                        resultPair = listenableFuture.get();
                        log.info("Thread " + resultPair.getKey().getId() + " returns result: " + resultPair.getValue());
                    } catch (Exception e) {
                        log.error(e);
                        failedThreadList.add(resultPair.getKey());
                    }
                }
            }, executorService);
            /**
            Futures.addCallback(listenableFuture, new FutureCallback<Pair<CountThread, Long>>() {
                @Override
                public void onSuccess(Pair<CountThread, Long> resultPair) {
                    log.info("Thread " + resultPair.getKey().getId() + " returns result: " + resultPair.getValue());
                }

                @Override
                public void onFailure(Throwable throwable) {
                    log.error(throwable);
                    Pair<CountThread, Long> resultPair = listenableFuture.get();
                    failedThreadList.add(resultPair.getKey());
                }
            }); */
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        new ThreadPoolExample(20).useFixedThreadPool(5);
    }

}
