package org.michaelliu.demo.java.thread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.Callable;

/**
 * Created by Michael on 7/25/16.
 */
public abstract class AbstractWordCountThread implements Callable<Long> {

    private static Log log = LogFactory.getLog(AbstractWordCountThread.class);

    protected String word;

    public AbstractWordCountThread() {
        this("hello");
    }

    public AbstractWordCountThread(String word) {
        this.word = word;
    }

    @Override
    public Long call() throws Exception {
        Long counter = increase(word);
        log.info(word + "'s counter: " + counter);
        return counter;
    }

    abstract Long increase(String word);

}
