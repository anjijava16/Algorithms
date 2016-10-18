package com.cci;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by sunilpatil on 10/17/16.
 */
public class Stack implements Iterable<Integer> {
    int size;
    private Node root;

    public static void main(String[] argv) {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        for (Integer i : stack)
            System.out.print(i + " ");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public int pop() {
        if (root != null) {
            int returnData = root.data;
            root = root.next;
            size--;
            return returnData;
        }
        return 0;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = root;
        root = node;
        size++;
    }

    public int peek() {
        return root.data;
    }

    @Override
    public Iterator<Integer> iterator() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        Node node = root;
        while (node != null) {
            integerArrayList.add(node.data);
            node = node.next;
        }
        return integerArrayList.iterator();
    }

    public int getSize() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "root=" + root +
                '}';
    }

    class Node {
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

}
