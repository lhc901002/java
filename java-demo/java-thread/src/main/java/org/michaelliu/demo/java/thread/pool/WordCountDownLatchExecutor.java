package org.michaelliu.demo.java.thread.pool;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.demo.java.thread.WordCountDownLatchThread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by michael on 2016/8/1.
 */
public class WordCountDownLatchExecutor {

    private static Log log = LogFactory.getLog(WordCountDownLatchExecutor.class);

    private static volatile Long maxCounter = -1l;

    private static void execute() {
        int poolSize = 2000;
        int threadSize = 10000;
        CyclicBarrier barrier = new CyclicBarrier(threadSize);
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);
        for (int i = 0; i < threadSize; i++) {
            WordCountDownLatchThread wordCountThread = new WordCountDownLatchThread("michael", barrier);
            final ListenableFuture<Long> listenableFuture = executorService.submit(wordCountThread);
            listenableFuture.addListener(new Runnable() {
                @Override
                public void run() {
                    Long counter = null;
                    try {
                        counter = listenableFuture.get();
                        maxCounter = maxCounter > counter ? maxCounter : counter;
                        log.info("Thread returns counter: " + counter);
                    } catch (Exception e) {
                        log.error(e);
                    }
                }
            }, executorService);
        }
        try {
            barrier.wait();
        } catch (InterruptedException e) {
            log.error(e);
        }
        if (!executorService.isShutdown()) {
            executorService.shutdownNow();
        }
        log.info("Counter has increased to " + maxCounter);
    }

    public static void main(String[] args) {
        execute();
    }

}
