package org.michaelliu.java.thread;

import java.util.concurrent.ConcurrentMap;

/**
 * Created by Michael on 2016/7/17.
 */
public class SafeWordCountThread implements Runnable {

    private ConcurrentMap<String, Long> wordCountMap;

    private String word;

    public SafeWordCountThread(ConcurrentMap<String, Long> wordCountMap, String word) {
        this.wordCountMap = wordCountMap;
        this.word = word;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(word + ": " + increase(word));
        }
    }

    private long increase(String word) {
        Long oldValue, newValue;
        while (true) {
            oldValue = wordCountMap.get(word);
            if (oldValue == null) {
                // Add the word firstly, initial the value as 1
                newValue = 1L;
                if (wordCountMap.putIfAbsent(word, newValue) == null) {
                    break;
                }
            } else {
                newValue = oldValue + 1;
                if (wordCountMap.replace(word, oldValue, newValue)) {
                    break;
                }
            }
        }
        return newValue;
    }

}
