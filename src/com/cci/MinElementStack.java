package com.cci;

/**
 * Created by sunilpatil on 10/18/16.
 */
public class MinElementStack {
    private Node root;

    public static void main(String[] argv) {
        MinElementStack minElementStack = new MinElementStack();

        minElementStack.push(10);
        System.out.println(minElementStack.root.minElement);
        minElementStack.push(6);
        System.out.println(minElementStack.root.minElement);
        minElementStack.push(11);
        System.out.println(minElementStack.root.minElement);
    }

    public int pop() {
        if (root != null) {
            int returnData = root.data;
            root = root.next;
            return returnData;
        }
        return 0;
    }

    public void push(int data) {
        int min = data;
        if (root != null) {
            min = Math.min(min, root.minElement);
        }
        Node node = new Node(data, min);
        node.next = root;
        root = node;
    }

    class Node {
        int data;
        int minElement;
        Node next = null;

        public Node(int data, int minElement) {
            this.data = data;
            this.minElement = minElement;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", minElement=" + minElement +
                    ", next=" + next +
                    '}';
        }
    }
}
