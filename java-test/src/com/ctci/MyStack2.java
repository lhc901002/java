package com.ctci;

import java.util.Stack;

/**
 * Created by baidu on 1/3/17.
 */
public class MyStack2 extends Stack<Integer> {

    private Stack<Integer> minStack;

    public MyStack2() {
        minStack = new Stack<>();
    }

    @Override
    public Integer push(Integer item) {
        Integer element = super.push(item);
        if (minStack.isEmpty() || item < minStack.peek()) {
            minStack.push(item);
        }
        return element;
    }

    @Override
    public Integer pop() {
        Integer element = super.pop();
        if (element != null && element.equals(minStack.peek())) {
            minStack.pop();
        }
        return element;
    }

    public Integer min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MyStack2 stack = new MyStack2();
        stack.push(3);
        stack.push(1);
        stack.push(9);
        stack.push(13);
        stack.push(-1);
        stack.push(7);
        System.out.println(stack.min());  // -1
        stack.pop();
        stack.pop();
        System.out.println(stack.min());  // 1
    }
}
