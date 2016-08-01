package org.michaelliu.demo.java.thread;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by michael on 2016/8/1.
 */
public class WordCountDownLatchThread extends AbstractWordCountThread {

    private static HashMap<String, Long> wordCountMap;

    private CyclicBarrier barrier;

    static {
        wordCountMap = new HashMap<>();
    }

    public WordCountDownLatchThread() {}

    public WordCountDownLatchThread(String word, CyclicBarrier barrier) {
        super(word);
        this.barrier = barrier;
    }

    private static final Object lock = new Object();

    @Override
    protected Long increase(String word) {

        synchronized (lock) {
            Long oldValue = wordCountMap.get(word);
            Long newValue = (oldValue == null) ? 1L : oldValue + 1;
            wordCountMap.put(word, newValue);
            return newValue;
        }

    }

}
