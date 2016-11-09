package org.michaelliu.demo.java.collection.test;

import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by Michael on 2016/11/2.
 */
public class TestSetWithMap {

    private static void testHashMapKey() {
        Map<String, String> hashMap = Maps.newHashMap();
        hashMap.put("a", "111");
        hashMap.put("b", "222");
        hashMap.put("c", "333");
        hashMap.put("d", "444");
        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
        Set<String> keySet = hashMap.keySet();
        Collection<String> valueSet = hashMap.values();
        System.out.println(entrySet);
        System.out.println(keySet);
        System.out.println(valueSet);
    }

    private static void testLinkedHashMapKey() {
        Map<String, String> linkedHashMap = Maps.newLinkedHashMap();
        linkedHashMap.put("a", "111");
        linkedHashMap.put("b", "222");
        linkedHashMap.put("c", "333");
        linkedHashMap.put("d", "444");
        Set<String> keySet = linkedHashMap.keySet();
        Collection<String> valueSet = linkedHashMap.values();
        System.out.println(keySet);
        System.out.println(valueSet);
    }

    private static void testTreeMapKey() {
        Map<String, String> treeMap = Maps.newTreeMap();
        treeMap.put("a", "111");
        treeMap.put("b", "222");
        treeMap.put("c", "333");
        treeMap.put("d", "444");
        Set<String> keySet = treeMap.keySet();
        Collection<String> valueSet = treeMap.values();
        System.out.println(keySet);
        System.out.println(valueSet);
    }

    public static void main(String[] args) {
        testHashMapKey();
//        testLinkedHashMapKey();
//        testTreeMapKey();
    }
}
