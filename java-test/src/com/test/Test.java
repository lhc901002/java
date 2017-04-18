package com.test;

public class Test {

//    public static void main(String[] args) throws InterruptedException {
//        // java序列化对比大小
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < 1000000; i++) {
//            map.put(i, i);
//        }
////        Integer[] nums = new Integer[1000000];
////        for (int i = 0; i < 1000000; i++) {
////            nums[i] = i;
////        }
//        // 强制回收HashMap及其元素
//        System.gc();
//        // 打印回收的内存大小
//        System.out.println(Runtime.getRuntime().freeMemory());
//
//    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 100000000; i++) {
            int x = i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
