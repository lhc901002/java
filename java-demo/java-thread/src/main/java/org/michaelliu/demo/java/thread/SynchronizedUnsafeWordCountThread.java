package org.michaelliu.demo.java.thread;

import java.util.HashMap;

/**
 * Created by Michael on 7/25/16.
 */
public class SynchronizedUnsafeWordCountThread extends AbstractWordCountThread {

    private static HashMap<String, Long> wordCountMap;

    static {
        wordCountMap = new HashMap<>();
    }

    public SynchronizedUnsafeWordCountThread() {
    }

    public SynchronizedUnsafeWordCountThread(String word) {
        super(word);
    }

    @Override
    protected synchronized Long increase(String word) {
        Long oldValue = wordCountMap.get(word);
        Long newValue = (oldValue == null) ? 1L : oldValue + 1;
        wordCountMap.put(word, newValue);
        return newValue;
    }

}
