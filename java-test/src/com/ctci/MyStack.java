package com.ctci;

/**
 * Created by baidu on 1/3/17.
 */
public class MyStack {

    private Integer[] elements;

    private int[] top;

    private int size;

    public MyStack() {
        this(10);
    }

    public MyStack(int size) {
        this.size = size;
        elements = new Integer[size * 3];
        top = new int[3];
        top[0] = -1;
        top[1] = -1;
        top[2] = -1;
    }

    public Integer pop(int id) {
        if (top[id] < 1) {
            return null;
        }
        Integer element = elements[id * size + top[id]];
        top[id]--;
        return element;
    }

    public Integer peak(int id) throws Exception {
        if (top[id] < 0) {
            return null;
        }
        return elements[id * size + top[id]];
    }

    public boolean push(int id, Integer value) {
        if (top[id] < size - 1) {
            top[id]++;
            elements[id * size + top[id]] = value;
            return true;
        }
        return false;
    }

    public void printOut() {
        for (int i = 0; i < 3; i++) {
            System.out.print("stack " + i + ": ");
            for (int cur = i * size; cur <= i * size + top[i]; cur++) {
                System.out.print(elements[cur] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(3);
        System.out.println(stack.push(1, 10));
        System.out.println(stack.push(1, 3));
        System.out.println(stack.push(1, 9));
        System.out.println(stack.push(1, 11));
        System.out.println(stack.pop(1));
        stack.printOut();
    }
}
