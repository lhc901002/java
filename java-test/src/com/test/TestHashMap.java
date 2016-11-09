package com.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75F, true);
        linkedHashMap.put("1", "Michael");
        linkedHashMap.put("2", "Lewis");
        linkedHashMap.put("3", "Stern");
        linkedHashMap.put("4", "Michell");
        System.out.println(linkedHashMap);  // print '{1=Michael, 2=Lewis, 3=Stern, 4=Michell}'
        linkedHashMap.put("2", "Harris");
        System.out.println(linkedHashMap);  // print '{1=Michael, 3=Stern, 4=Michell, 2=Harris}'
        linkedHashMap.get("3");
        linkedHashMap.get("1");
        System.out.println(linkedHashMap);  // print '{4=Michell, 2=Harris, 3=Stern, 1=Michael}'
    }
}
