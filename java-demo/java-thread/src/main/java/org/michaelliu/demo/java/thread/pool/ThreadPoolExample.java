package org.michaelliu.demo.java.thread.pool;

import com.google.common.collect.Lists;
import javafx.util.Pair;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.demo.java.thread.CountThread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by michael on 2016/7/23.
 */
public class ThreadPoolExample {

    private static Log log = LogFactory.getLog(ThreadPoolExample.class);

    private List<CountThread> countThreadList;

    private List<CountThread> failedThreadList;

    public ThreadPoolExample(int threadNum) {
        countThreadList = Lists.newArrayList();
        for (int i = 1; i <= threadNum; i++) {
            countThreadList.add(new CountThread(i));
        }
        failedThreadList = Lists.newArrayList();
    }

    public void useFixedThreadPool(int size) {
        ExecutorService executor = Executors.newFixedThreadPool(size);
        List<Future<Pair<CountThread, Long>>> resultList = Lists.newArrayList();
        for (CountThread thread : countThreadList) {
            Future<Pair<CountThread, Long>> result = executor.submit(thread);
            resultList.add(result);
        }
        executor.shutdown();
        printThreadResult(resultList);
    }

    private void printThreadResult(List<Future<Pair<CountThread, Long>>> resultList) {
        for (Future<Pair<CountThread, Long>> result : resultList) {
            Pair<CountThread, Long> resultPair = null;
            try {
                resultPair = result.get();
                log.info("Thread " + resultPair.getKey().getId() + " returns result: " + resultPair.getValue());
            } catch (Exception e) {
                log.error(e);
                failedThreadList.add(resultPair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        new ThreadPoolExample(20).useFixedThreadPool(5);
    }

}
