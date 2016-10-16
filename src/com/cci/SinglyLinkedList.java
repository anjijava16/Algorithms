package com.cci;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by sunilpatil on 10/14/16.
 */
public class SinglyLinkedList implements Iterable {
    private Node root;

    /**
     * @param
     */
    public static int addTwoLinkedList(SinglyLinkedList first, SinglyLinkedList second) {
        int returnValue = 0;
        int placeValue = 0;
        Node firstNode = first.root;
        Node secondNode = second.root;
        int carry = 0;
        while (firstNode != null && secondNode != null) {
            int currentSum = firstNode.data + secondNode.data + carry;
            carry = currentSum / 10;
            int actualAddValue = currentSum % 10;

            returnValue = returnValue + tenPower(currentSum, placeValue++);
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return returnValue;
    }

    private static int tenPower(int number, int placeValue) {
        for (int i = 0; i < placeValue; i++) {
            number = number * 10;
        }
        return number;
    }

    public static void main(String[] argv) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        System.out.println(singlyLinkedList.get(2));

        singlyLinkedList.appendToHead(1);
        singlyLinkedList.appendToHead(2);
        singlyLinkedList.appendToHead(3);


        System.out.println("First List");
        singlyLinkedList.printLinkedList();

        SinglyLinkedList second = new SinglyLinkedList();
        second.appendToHead(8);
        second.appendToHead(8);
        second.appendToHead(8);

        System.out.println(SinglyLinkedList.addTwoLinkedList(singlyLinkedList, second));
    }

    @Override
    public Iterator iterator() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        Node next = root;
        while (next != null) {
            integerArrayList.add(next.data);
            next = next.next;
        }
        return integerArrayList.iterator();
    }

    public void appendToTail(int d) {
        Node newNode = new Node(d);
        if (root == null) {
            root = newNode;
            return;
        }
        Node n = root;
        while (n.next != null)
            n = n.next;
        n.next = newNode;
    }

    public void appendToHead(int d) {
        Node newNode = new Node(d);
        newNode.next = root;
        root = newNode;
    }

    public Node get(int d) {

        Node next = root;
        while (next != null) {
            if (next.data == d)
                return next;
            next = next.next;
        }
        return null;
    }

    public Node deleteNode(Node head, int d) {
        if (head == null)
            return null;
        if (head.data == d) {
            return head.next;
        }
        Node n = head;
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }

    public void printReverseOrder(Node root) {
        if (root == null)
            return;
        printReverseOrder(root.next);
        System.out.print(root.data);
    }

    public void removeDuplicates() {
        if (root == null)
            return;

        HashSet<Integer> integerHashSet = new HashSet<>();
        Node n = root;
        integerHashSet.add(n.data);
        while (n.next != null) {
            if (integerHashSet.contains(n.next.data)) {
                n.next = n.next.next;
                continue;
            } else {
                integerHashSet.add(n.next.data);
            }
            n = n.next;
        }
    }

    /**
     * Implement an algorithm to  nd the nth to last element of a singly linked list.
     */
    public void printNthElementFromEnd(int fromEnd) {
        if (root == null)
            return;
        int counter = 0;
        Node nthElement = null;
        Node n = root;
        while (n != null) {
            if (counter < fromEnd) {
                counter++;
            } else if (counter == fromEnd) {
                nthElement = root;
                counter++;
            } else {
                nthElement = nthElement.next;
            }
            n = n.next;
        }
        if (nthElement != null)
            System.out.println(nthElement.data);
        else
            System.out.println("null");
    }

    /**
     * Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
     */

    public void deleteCurrentNode(Node node) {
        if (node != null && node.next != null) {
            node.data = node.next.data;
            node.next = node.next.next;
        }

    }

    public void printLinkedList() {
        if (root == null)
            return;
        Node n = root;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
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
