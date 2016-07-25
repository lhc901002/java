package org.michaelliu.demo.java.thread.pool;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.demo.java.thread.FileWriteTask;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by michael on 2016/7/23.
 *
 * Run FileWriteTask, make sure each task can write a new line into
 * the file orderly.
 */
public class FileWriteTaskExecutor {

    private static Log log = LogFactory.getLog(FileWriteTaskExecutor.class);

    private List<FileWriteTask> failedTaskList = Lists.newArrayList();

    private AtomicInteger finishedSize = new AtomicInteger(0);

    private volatile int exceptionSize = 0;

    public void executeTaskList(List<FileWriteTask> taskList, int poolSize) {
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);
        for (FileWriteTask task : taskList) {
            final ListenableFuture<Integer> listenableFuture = executorService.submit(task);
            listenableFuture.addListener(new Runnable() {
                @Override
                public void run() {
                    Integer result = null;
                    try {
                        result = listenableFuture.get();
                        log.info("Thread " + result + " write a line into the file.");
                    } catch (Exception e) {
                        log.error("Thread " + result + " throws an exception: " + e);
                        exceptionSize++;
                    } finally {
                        if (listenableFuture.isDone()) {
                            finishedSize.incrementAndGet();
                        }
                    }
                }
            }, executorService);
        }
        while (finishedSize.get() != taskList.size()) {}
        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
        log.info("Task finished with " + exceptionSize + " exceptions.");
    }

    public static void main(String[] args) {
        List<FileWriteTask> taskList = Lists.newArrayList();
        for (int i = 0; i < 200000; i++) {
            taskList.add(new FileWriteTask("output.txt"));
        }
        new FileWriteTaskExecutor().executeTaskList(taskList, 20000);
    }

}
