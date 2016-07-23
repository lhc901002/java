package org.michaelliu.demo.java.thread;

import javafx.util.Pair;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by michael on 2016/7/23.
 */
public class CountThread implements Callable<Pair<CountThread, Long>> {

    private static Log log = LogFactory.getLog(CountThread.class);

    private static AtomicLong counter;

    static {
        counter = new AtomicLong(0);
    }

    private Integer id;

    public CountThread(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public Pair<CountThread, Long> call() throws Exception {
        long curValue = counter.incrementAndGet();
        log.info("Thread " + id + "\tCounter is now: " + curValue);
        Thread.sleep(5000);
        return new Pair<>(this, curValue);
    }

}
