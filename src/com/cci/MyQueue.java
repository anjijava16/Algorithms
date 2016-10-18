package com.cci;

/**
 * Created by sunilpatil on 10/18/16.
 */
public class MyQueue {
    Stack stack1, stack2;

    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public static void main(String[] argv) {
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        System.out.println("myQueue.dequeue() ->" + myQueue.dequeue());
        myQueue.enqueue(30);
        System.out.println("myQueue.dequeue() ->" + myQueue.dequeue());
        System.out.println("myQueue.dequeue() ->" + myQueue.dequeue());

    }

    public void enqueue(int n) {
        stack1.push(n);
    }

    public int dequeue() {
        if (!stack2.empty())
            return stack2.pop();
        while (!stack1.empty())
            stack2.push(stack1.pop());
        return stack2.pop();
    }

    public int size() {
        return stack1.getSize() + stack2.getSize();
    }

    public int peek() {
        if (!stack2.empty())
            stack2.peek();
        while (!stack1.empty())
            stack2.push(stack1.pop());
        return stack2.pop();
    }
}
