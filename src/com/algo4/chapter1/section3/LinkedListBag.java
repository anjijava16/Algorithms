package com.algo4.chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by sunilpatil on 9/14/16.
 */
public class LinkedListBag<Item> implements Iterable<Item> {

    private Node first;
    private int N;
    public LinkedListBag(){

    }
    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public boolean isEmpty() {
        return first==null;
    }

    public int size() {
        return N;
    }

    private class Node{
        Item item;
        Node next;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item returnItem = current.item;
            current = current.next;
            return returnItem;
        }
    }

    public static void main(String[] argv){
        LinkedListBag<String> bag = new LinkedListBag<>();

        while(!StdIn.isEmpty()){
            String value = StdIn.readString();
            if(!value.equals("-"))
                bag.add(value);
            else if(!bag.isEmpty()) {
                for(String str: bag)
                    System.out.print(str + " ");

            }

        }

        StdOut.println("( " + bag.size() +" left on stack)");

    }
}
