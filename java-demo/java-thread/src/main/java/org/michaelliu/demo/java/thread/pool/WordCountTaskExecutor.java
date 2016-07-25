package org.michaelliu.demo.java.thread.pool;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.demo.java.thread.AbstractWordCountThread;
import org.michaelliu.demo.java.thread.SynchronizedSafeWordCountThread;
import org.michaelliu.demo.java.thread.WordCountThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Michael on 7/25/16.
 */
public class WordCountTaskExecutor {

    private static Log log = LogFactory.getLog(WordCountTaskExecutor.class);

    private static AtomicLong finishedSize = new AtomicLong(0);

    private static volatile Long maxCounter = -1l;

    private static void execute(String threadType) {
        int poolSize = 2000;
        int threadSize = 10000;
        String word = "Michael";
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);
        for (int i = 0; i < threadSize; i++) {
            AbstractWordCountThread wordCountThread = WordCountThreadFactory.createThread(threadType);
            final ListenableFuture<Long> listenableFuture = executorService.submit(new SynchronizedSafeWordCountThread(word));
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
                    } finally {
                        if (listenableFuture.isDone()) {
                            finishedSize.incrementAndGet();
                        }
                    }
                }
            }, executorService);
        }
        while (finishedSize.get() != threadSize) {}
        executorService.shutdown();
        log.info("Counter has increased to " + maxCounter);
    }

    public static void main(String[] args) {
        execute("UnsafeWordCountThead");
        execute("AtomicSafeWordCountThread");
        execute("SynchronizedSafeWordCountThread");

    }

}
