package org.michaelliu.demo.java.collection.test;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by Michael on 2016/11/2.
 */
public class TestSet {

    private static void testHashSet() {
        Set<String> hashSet = Sets.newHashSet();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        hashSet.add("d");
        System.out.println(hashSet);

        Set<Integer> hashSet2 = Sets.newHashSet();
        hashSet2.add(1);
        hashSet2.add(2);
        hashSet2.add(3);
        hashSet2.add(4);
        System.out.println(hashSet2);
    }

    private static void testLinkedHashSet() {
        Set<String> linkedHashSet = Sets.newLinkedHashSet();
        linkedHashSet.add("a");
        linkedHashSet.add("b");
        linkedHashSet.add("c");
        linkedHashSet.add("d");
        System.out.println(linkedHashSet);

        Set<Integer> linkedHashSet2 = Sets.newLinkedHashSet();
        linkedHashSet2.add(1);
        linkedHashSet2.add(2);
        linkedHashSet2.add(3);
        linkedHashSet2.add(4);
        System.out.println(linkedHashSet2);
    }

    private static void testTreeSet() {
        Set<String> treeSet = Sets.newTreeSet();
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add("c");
        treeSet.add("d");
        System.out.println(treeSet);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            testHashSet();
//            testLinkedHashSet();
//            testTreeSet();
        }
    }
}
