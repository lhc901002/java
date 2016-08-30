package org.michaelliu.demo.java.lang;

/**
 * Created by Michael on 8/26/16.
 */
public class IntegerExample {

    public static void main(String[] args) {
        int i1 = 10;
        Integer i2 = 10;
        Integer i3 = new Integer(10);
        Integer i4 = new Integer(10);
        Integer i5 = 10;
        Integer i6 = 200;
        Integer i7 = 200;
        int i8 = 200;

        System.out.println(i1 == i2);     //true
        System.out.println(i1 == i3);     //true
        System.out.println(i2 == i3);     //false
        System.out.println(i3 == i4);     //false
        System.out.println(i2 == i5);     //true
        System.out.println(i6 == i7);     //false
        System.out.println(i6 == i8);     //true

        System.out.println(i2.equals(i1));     //true
        System.out.println(i3.equals(i1));     //true
        System.out.println(i2.equals(i3));     //true
        System.out.println(i3.equals(i4));     //true
        System.out.println(i2.equals(i5));     //true
        System.out.println(i6.equals(i7));     //true
        System.out.println(i6.equals(i8));     //true
    }

}
