package org.michaelliu.demo.java.thread;

import java.util.HashMap;

/**
 * Created by Michael on 2016/7/17.
 */
public class SynchronizedSafeWordCountThread extends AbstractWordCountThread {

    private static HashMap<String, Long> wordCountMap;

    static {
        wordCountMap = new HashMap<>();
    }

    public SynchronizedSafeWordCountThread() {}

    public SynchronizedSafeWordCountThread(String word) {
        super(word);
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
