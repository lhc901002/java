package com.ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 1/4/17.
 */
public class Recursion {
    public static List<List<String>> subSet(List<String> rawSet) {
        List<List<String>> subset;
        if (rawSet.isEmpty()) {
            subset = new ArrayList<>();
            subset.add(new ArrayList<String>());
        } else {
            // create a copy of raw set, otherwise, element will be removed from the raw set.
            List<String> copyRawSet = new ArrayList<>();
            copyRawSet.addAll(rawSet);
            String item = copyRawSet.get(copyRawSet.size() - 1);
            copyRawSet.remove(copyRawSet.size() - 1);
            subset = subSet(copyRawSet);
            List<List<String>> addSet = new ArrayList<>();  // set to be added into the subset
            for (List<String> set : subset) {
                List<String> copySet = new ArrayList<>();
                copySet.addAll(set);
                copySet.add(item);
                addSet.add(copySet);
            }
            subset.addAll(addSet);
        }
        return subset;
    }

    public static void main(String[] args) {
        List<String> set = new ArrayList<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        System.out.println(set);
        List<List<String>> subset = subSet(set);
        System.out.println(subset);
    }
}
