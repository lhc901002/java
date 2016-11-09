package org.michaelliu.demo.java.collection.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michael on 2016/11/2.
 */
public class TestHashMap {

    public static void main(String[] args) {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("a", 111);
        hashMap.put("b", 222);
        hashMap.put("a", 333);
        System.out.println(hashMap.get("a"));
        System.out.println(hashMap.get("b"));
        System.out.println(hashMap.get("c"));

        Map<String, Object> srcMap = new HashMap<>();
        srcMap.put("a", "aaa");
        srcMap.put("b", "bbb");
        srcMap.put("c", "ccc");
        hashMap.putAll(srcMap);
        System.out.println(hashMap.get("a"));
        System.out.println(hashMap.get("b"));
        System.out.println(hashMap.get("c"));
    }

}
