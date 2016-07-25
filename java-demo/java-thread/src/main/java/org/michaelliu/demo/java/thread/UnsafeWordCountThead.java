package org.michaelliu.demo.java.thread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;

/**
 * Created by Michael on 2016/7/17.
 */
public class UnsafeWordCountThead extends AbstractWordCountThread {

    private static Log log = LogFactory.getLog(UnsafeWordCountThead.class);

    private static HashMap<String, Long> wordCountMap;

    static {
        wordCountMap = new HashMap<>();
    }

    public UnsafeWordCountThead() {}

    public UnsafeWordCountThead(String word) {
        super(word);
    }

    @Override
    protected Long increase(String word) {
        Long oldValue = wordCountMap.get(word);
        Long newValue = (oldValue == null) ? 1L : oldValue + 1;
        wordCountMap.put(word, newValue);
        return newValue;
    }

}
