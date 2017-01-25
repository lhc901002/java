package com.test;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        // java序列化对比大小
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 1000000; i++) {
            map.put(i, i);
        }
//        Integer[] nums = new Integer[1000000];
//        for (int i = 0; i < 1000000; i++) {
//            nums[i] = i;
//        }
        // 强制回收HashMap及其元素
        System.gc();
        // 打印回收的内存大小
        System.out.println(Runtime.getRuntime().freeMemory());

    }
}
