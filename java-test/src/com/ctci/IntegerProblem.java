package com.ctci;

/**
 * Created by Michael on 1/11/17.
 */
public class IntegerProblem {

    static int reverse(int number) {
        int result = 0;
        while (number != 0) {
            int digit = number % 10;
            int tmpResult = result * 10 + digit;  // Integer range overflow might happen when computing result * 10
//            // After reversion, the number is out of the range of Integer, return 0.
//            if (tmpResult > Integer.MAX_VALUE || tmpResult < Integer.MIN_VALUE) {
//                return 0;
//            }
            // if unequal, it means range overflow happens, cannot reversed the number.
            if ((tmpResult - digit) / 10 != result) {
                return 0;
            }
            result = tmpResult;
            number /= 10;
        }
        return result;
    }

    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Not an integer");
        }
        int result = 0, i = 0;
        boolean negFlag = false, hasDigit = false;
        // eliminate empty space on the left side of digits
        while (str.charAt(i) == ' ') {
            i++;
        }
        if (str.charAt(i) == '-') {
            i++;
            negFlag = true;
        } else if (str.charAt(i) == '+') {
            i++;
            negFlag = false;
        }
        for (; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                hasDigit = true;
                int digit = str.charAt(i) - '0';
                int tmpResult = result * 10 + digit;
                if ((tmpResult - digit) / 10 != result) {
                    throw new IllegalArgumentException("Input out of range of integer");
                }
                result = tmpResult;
            } else if (str.charAt(i) == ' ') {  // eliminate empty space within or on the right of digits
                continue;
            } else {
                throw new IllegalArgumentException("Not an integer");
            }
        }
        // check whether string contains characters from '0' to '9'
        if (!hasDigit) {
            throw new IllegalArgumentException("Not an integer");
        }
        // add '-' for negative number
        if (negFlag) {
            result = 0 - result;
        }
        return result;
    }

    static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        if (number >= 0 && number < 10) {
            return true;
        }
        // compute the number of digits
        int numCopy = number, digitCount = 0;
        while (numCopy > 0) {
            numCopy /= 10;
            digitCount++;
        }
        for (int i = 1; i <= digitCount / 2; i++) {
            // If finding unequal digits in mirror
            if (getDigit(number, i) != getDigit(number, digitCount - i + 1)) {
                return false;
            }
        }
        return true;
    }

    static int getDigit(int number, int bit) {
        return number / (int) Math.pow(10, bit - 1) % 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));      // true
        System.out.println(isPalindrome(3));      // true
        System.out.println(isPalindrome(12321));  // true
        System.out.println(isPalindrome(11));     // true
        System.out.println(isPalindrome(123));    // false
        System.out.println(isPalindrome(-4));     // false
    }

}
