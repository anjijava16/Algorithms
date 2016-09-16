package com.algo4.chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by sunilpatil on 9/12/16.
 */
public class Stack<Item> implements Iterable<Item> {
    Node first;
    int size = 0;

    public Stack(){

    }

    public void push(Item item){
        Node newFirst = new Node();
        newFirst.item = item;
        newFirst.next=first;
        size++;
        first = newFirst;
    }

    public Item pop(){
        Node oldFirst = first;
        first = oldFirst.next;
        size --;
        return oldFirst.item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
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
        Stack<String> linkedListStack = new Stack<>();

        while(!StdIn.isEmpty()){
            String value = StdIn.readString();
            if(!value.equals("-"))
                linkedListStack.push(value);
            else if(!linkedListStack.isEmpty())
                StdOut.println(linkedListStack.pop() + " ");

        }

        StdOut.println("( " + linkedListStack.size() +" left on stack)");

    }
}
