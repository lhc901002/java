package org.michaelliu.java.thread;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Michael on 2016/7/17.
 */
public class SafeWordCountThread2 implements Runnable {

    private ConcurrentMap<String, AtomicLong> wordCountMap;

    private String word;

    public SafeWordCountThread2(ConcurrentMap<String, AtomicLong> wordCountMap, String word) {
        this.wordCountMap = wordCountMap;
        this.word = word;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(word + ": " + increase(word));
        }
    }

    public long increase(String word) {
        AtomicLong number = wordCountMap.get(word);
        if (number == null) {
            AtomicLong newNumber = new AtomicLong(0);
            number = wordCountMap.putIfAbsent(word, newNumber);
            if (number == null) {
                number = newNumber;
            }
        }
        return number.incrementAndGet();
    }

}
