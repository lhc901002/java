package org.michaelliu.demo.java.thread;

/**
 * Created by Michael on 7/25/16.
 */
public class WordCountThreadFactory {

    public static AbstractWordCountThread createThread(String type) {
        AbstractWordCountThread wordCountThread = null;
        if (type.equals("UnsafeWordCountThead")) {
            wordCountThread = new UnsafeWordCountThead();
        } else if (type.equals("AtomicSafeWordCountThread")) {
            wordCountThread = new AtomicSafeWordCountThread();
        } else if (type.equals("SynchronizedSafeWordCountThread")) {
            wordCountThread = new SynchronizedSafeWordCountThread();
        } else if (type.equals("SynchronizedUnsafeWordCountThread")) {
            wordCountThread = new SynchronizedUnsafeWordCountThread();
        }
        return wordCountThread;
    }

}
