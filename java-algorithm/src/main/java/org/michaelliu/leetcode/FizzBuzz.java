package org.michaelliu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 1/25/17.
 */
public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> retList = new ArrayList<String>();
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    retList.add("FizzBuzz");
                } else if (i % 3 == 0) {
                    retList.add("Fizz");
                } else if (i % 5 == 0) {
                    retList.add("Buzz");
                } else {
                    retList.add(String.valueOf(i));
                }
            }
        }
        return retList;
    }

    public static void main(String[] args) {
        List<String> list = fizzBuzz(15);
        System.out.println(list);
    }
}
