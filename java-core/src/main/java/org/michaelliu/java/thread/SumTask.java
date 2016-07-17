package org.michaelliu.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Michael on 2016/7/17.
 */
public class SumTask implements Callable<Long> {

    private AtomicLong number;

    public SumTask(AtomicLong number) {
        this.number = number;
    }

    /**
     * @return result of the increment
     * @throws Exception
     */
    @Override
    public Long call() throws Exception {
        Long result = null;
        for (int i = 0; i < 1000; i++) {
            result = number.incrementAndGet();
        }
        return result;
    }

}
