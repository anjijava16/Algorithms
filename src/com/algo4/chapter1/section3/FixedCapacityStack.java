package com.algo4.chapter1.section3;

import java.util.Iterator;

/**
 * Created by sunilpatil on 9/13/16.
 */
public class FixedCapacityStack<Item> implements Iterable<Item>{
    private Item[] items;
    private int N;

    public FixedCapacityStack(int size){
        items = (Item[]) new Object[size];
    }

    public void push(Item item){
        if(N == items.length)
            resize(items.length*2);
        items[N++] = item;
    }

    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i =0 ; i < N ; i++){
            temp[i] = items[i];
        }
        items = temp;
    }

    public Item pop(){
        Item item = items[--N];
        items[N] = null;
        if(N > 0 && N == items.length/4)
            resize(N/2);
        return item;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N ==0;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
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
        FixedCapacityStack<String> fixedCapacityStack = new FixedCapacityStack<>(2);
        fixedCapacityStack.push("One");
        fixedCapacityStack.push("Two");
        fixedCapacityStack.push("Three");

        System.out.println(fixedCapacityStack.size());


        for(String s: fixedCapacityStack){
            System.out.println("Value -> " +s);
        }

    }
}
