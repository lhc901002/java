package com.test;

public class TestStatic {

    private static int a;

    private int b;

    static {
        TestStatic.a = 3;
        System.out.println(a);  // print '3'
        TestStatic t = new TestStatic();
        t.f();  // print 'hhahhahah'
        t.b = 1000;
        System.out.println(t.b);  // print '1000'
    }

    static {
        TestStatic.a = 4;
        System.out.println(a);  // print '4'
    }

    public static void main(String[] args) {
    }

    static {
        TestStatic.a = 5;
        System.out.println(a);  // print '5'
    }

    public void f() {
        System.out.println("hhahhahah");
    }
}
