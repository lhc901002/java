package com.ctci;

/**
 * Created by Michael on 1/16/17.
 */
public class DP {

    static int maxRevenue(int[] price, int n) {
        if (n == 0) {
            return 0;
        }
        int maxPrice = 0;
        for (int i = 0; i < n; i++) {
            maxPrice = Math.max(maxPrice, price[i] + maxRevenue(price, n - i - 1));
        }
        return maxPrice;
    }

    public static void main(String[] args) {
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
        System.out.println(maxRevenue(price, 5));
    }
}
