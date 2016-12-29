package com.test;

import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
//        Map<String, String> linkedHashMap = new LinkedHashMap<String, String>(16, 0.75F, true);
//        linkedHashMap.put("1", "Michael");
//        linkedHashMap.put("2", "Lewis");
//        linkedHashMap.put("3", "Stern");
//        linkedHashMap.put("4", "Michell");
//        System.out.println(linkedHashMap);  // print '{1=Michael, 2=Lewis, 3=Stern, 4=Michell}'
//        linkedHashMap.put("2", "Harris");
//        System.out.println(linkedHashMap);  // print '{1=Michael, 3=Stern, 4=Michell, 2=Harris}'
//        linkedHashMap.get("3");
//        linkedHashMap.get("1");
//        System.out.println(linkedHashMap);  // print '{4=Michell, 2=Harris, 3=Stern, 1=Michael}'
        long t1 = System.currentTimeMillis();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 1000000; i++) {
            map.put(i, i);
        }

        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        // 强制回收HashMap及其元素
        System.gc();
        long t3 = System.currentTimeMillis();
        System.out.println(t3 - t2);
        // 打印回收的内存大小
        System.out.println(Runtime.getRuntime().freeMemory());  // print ''
//        System.out.println(Runtime.getRuntime().totalMemory());
//        System.out.println(Runtime.getRuntime().maxMemory());
    }
}

