package com.algo4.chapter1.section3;

import java.util.Iterator;

/**
 * Created by sunilpatil on 9/13/16.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] items = (Item[])new Object[1];
    private int N = 0;

    public boolean isEmpty(){
        return N ==0;
    }

    public int size(){
        return N;
    }

    public void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N ; i++)
            temp[i] = items[i];

        items = temp;
    }

    public void push(Item item){
        if(N == items.length)
            resize(items.length*2);
        items[N++] = item;
    }

    public Item pop(){
        Item item = items[--N];
        items[N] = null;

        if(N > 0 && N == items.length/4 )
            resize(items.length/2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }

    private class ReverseIterator implements Iterator<Item>{
        private int i = N;
        @Override
        public boolean hasNext() {
            return i >0;
        }

        @Override
        public Item next() {
            return items[--i];
        }
    }

    public static void main(String[] argv){
        ResizingArrayStack<String> resizingArrayStack = new ResizingArrayStack<>();
        resizingArrayStack.push("One");
        resizingArrayStack.push("Two");
        resizingArrayStack.push("Three");
        resizingArrayStack.push("Four");

        for(String s: resizingArrayStack)
            System.out.println(s);

        System.out.println("Popping value " + resizingArrayStack.pop());
        System.out.println("Popping value " + resizingArrayStack.pop());
        System.out.println("Popping value " + resizingArrayStack.pop());
        System.out.println("Popping value " + resizingArrayStack.pop());
    }
}
