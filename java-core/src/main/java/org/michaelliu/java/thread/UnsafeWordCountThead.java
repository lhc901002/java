package org.michaelliu.java.thread;

import java.util.HashMap;

/**
 * Created by Michael on 2016/7/17.
 */
public class UnsafeWordCountThead implements Runnable {

    private HashMap<String, Long> wordCountMap;

    private String word;

    public UnsafeWordCountThead(HashMap<String, Long> wordCountMap, String word) {
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
        Long oldValue = wordCountMap.get(word);
        Long newValue = (oldValue == null) ? 1L : oldValue + 1;
        wordCountMap.put(word, newValue);
        return newValue;
    }

}
