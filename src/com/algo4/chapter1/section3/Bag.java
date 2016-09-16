package com.algo4.chapter1.section3;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by sunilpatil on 9/12/16.
 */
public class Bag<Item> implements Iterable<Item> {
    private Node first;
    public Bag(){

    }

    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        int size = 0;
        Node nextItem = first;
        while(nextItem != null){
            size++;
            nextItem = nextItem.next;
        }
        return size;
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
            Item item = current.item;
            current = current.next;
            return item;
        }
    }



    private class Node{
        Item item;
        Node next;
    }

    public static void main(String[] argv){
        Bag<Integer> intBag = new Bag<>();
        System.out.println("Is bag empty " + intBag.isEmpty());
        intBag.add(10);
        System.out.println("Is bag empty " + intBag.isEmpty());
        System.out.println("Size of the bag " + intBag.size());
        intBag.add(20);
        intBag.add(30);
        intBag.add(40);
        intBag.add(50);
        System.out.println("Size of the bag " + intBag.size());
        for(Integer i : intBag)
            System.out.println(i);
    }
}
