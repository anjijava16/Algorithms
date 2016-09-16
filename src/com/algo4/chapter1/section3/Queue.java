package com.algo4.chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by sunilpatil on 9/12/16.
 */
public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    public Queue(){

    }

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty())
            first = last;
        else
            oldLast.next= last;

        N++;
    }

    public Item dequeue(){
        Item returnItem = first.item;
        first = first.next;
        if(isEmpty())
            last = null;
        N--;
        return returnItem;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    private class Node{
        Item item;
        Node next;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }


    public static void main(String[] argv){
        Queue<String> queue = new Queue<>();

        while(!StdIn.isEmpty()){
            String value = StdIn.readString();
            if(!value.equals("-"))
                queue.enqueue(value);
            else if(!queue.isEmpty())
                StdOut.println(queue.dequeue() + " ");

        }

        StdOut.println("( " + queue.size() +" left on stack)");

    }
}
