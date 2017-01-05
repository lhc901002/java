package com.ctci;

import java.util.Stack;

/**
 * Created by baidu on 1/4/17.
 */
public class MyQueue {

    private Stack<Integer> enStack;

    private Stack<Integer> deStack;

    private Integer head;

    private Integer tail;

    public MyQueue() {
        enStack = new Stack<>();
        deStack = new Stack<>();
        head = null;
        tail = null;
    }

    public void enQueue(Integer item) {
        if (enStack.isEmpty() && deStack.isEmpty()) {
            head = item;
        }
        tail = item;
        enStack.push(item);
    }

    public Integer deQueue() {
        if (deStack.isEmpty()) {
            move(enStack, deStack);
        }
        Integer item = null;
        if (!deStack.isEmpty()) {
            item = deStack.pop();
        }
        if (deStack.isEmpty()) {
            move(enStack, deStack);
        }
        if (deStack.isEmpty()) {
            head = null;
            tail = null;
        } else {
            head = deStack.peek();
        }
        return item;
    }

    private void move(Stack<Integer> srcStack, Stack<Integer> destStack) {
        while (!srcStack.isEmpty()) {
            destStack.push(srcStack.pop());
        }
    }

    public Integer getHead() {
        return head;
    }

    public Integer getTail() {
        return tail;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enQueue(1);System.out.println(queue.getHead() + " " + queue.getTail());
        queue.enQueue(2);System.out.println(queue.getHead() + " " + queue.getTail());
        System.out.println(queue.deQueue());System.out.println(queue.getHead() + " " + queue.getTail());
        queue.enQueue(3);System.out.println(queue.getHead() + " " + queue.getTail());
        System.out.println(queue.deQueue());
        queue.enQueue(4);System.out.println(queue.getHead() + " " + queue.getTail());
        queue.enQueue(5);System.out.println(queue.getHead() + " " + queue.getTail());
        queue.enQueue(6);System.out.println(queue.getHead() + " " + queue.getTail());
        System.out.println(queue.deQueue());System.out.println(queue.getHead() + " " + queue.getTail());
        System.out.println(queue.deQueue());System.out.println(queue.getHead() + " " + queue.getTail());
        System.out.println(queue.deQueue());System.out.println(queue.getHead() + " " + queue.getTail());
        System.out.println(queue.deQueue());System.out.println(queue.getHead() + " " + queue.getTail());
        System.out.println(queue.deQueue());System.out.println(queue.getHead() + " " + queue.getTail());
    }
}
