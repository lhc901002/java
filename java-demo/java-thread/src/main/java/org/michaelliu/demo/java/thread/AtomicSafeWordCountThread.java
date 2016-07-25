package org.michaelliu.demo.java.thread;

import com.google.common.collect.Maps;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Michael on 7/25/16.
 */
public class AtomicSafeWordCountThread extends AbstractWordCountThread {

    private static Log log = LogFactory.getLog(AtomicSafeWordCountThread.class);

    private static ConcurrentMap<String, AtomicLong> wordCountMap;

    static {
        wordCountMap = Maps.newConcurrentMap();
    }

    public AtomicSafeWordCountThread() {
    }

    public AtomicSafeWordCountThread(String word) {
        super(word);
    }

    @Override
    protected Long increase(String word) {
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
