package org.michaelliu.java.collection;

import org.michaelliu.java.thread.SafeWordCountThread;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Michael on 2016/7/17.
 */
public class HashMapDemo {

    public static void main(String[] args) {
        ConcurrentMap<String, Long> concurrentMap = new ConcurrentHashMap<String, Long>();
        ConcurrentMap<String, AtomicLong> concurrentMap2 = new ConcurrentHashMap<String, AtomicLong>();
        HashMap<String, Long> hashMap = new HashMap<>();
        for (int i = 0; i < 2000; i++) {
            new Thread(new SafeWordCountThread(concurrentMap, "hello")).start();
//            new Thread(new SafeWordCountThread2(concurrentMap2, "hello")).start();
//            new Thread(new UnsafeWordCountThead(hashMap, "hello")).start();
        }
    }

}
