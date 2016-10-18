package com.cci;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by sunilpatil on 10/17/16.
 */
public class Queue implements Iterable<Integer> {
    private Node first, last;

    public static void main(String[] argv) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        for (Integer i : queue)
            System.out.print(i + " ");

        System.out.println();
        System.out.println("queue.dequeue() ->" + queue.dequeue());
        ;
        System.out.println("queue.dequeue() ->" + queue.dequeue());
        ;
        System.out.println("queue.dequeue() ->" + queue.dequeue());
        ;

        for (Integer i : queue)
            System.out.print(i + " ");
    }

    public void enqueue(int item) {
        Node next = new Node(item);

        if (first == null) {
            first = next;
            last = next;
        } else {
            last.next = next;
            last = next;
        }

    }

    public int dequeue() {
        int returnValue = -1;
        if (first != null) {
            returnValue = first.data;
            first = first.next;
        }
        return returnValue;
    }

    @Override
    public Iterator<Integer> iterator() {
        ArrayList<Integer> returnList = new ArrayList<>();
        Node n = first;
        while (n != null) {
            returnList.add(n.data);
            n = n.next;
        }
        return returnList.iterator();
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
