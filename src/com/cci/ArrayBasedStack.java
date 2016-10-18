package com.cci;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by sunilpatil on 10/17/16.
 */
public class ArrayBasedStack implements Iterable<Integer> {
    int[] items;
    int counter;

    public ArrayBasedStack(int size) {
        items = new int[size];
        counter = 0;
    }

    public static void main(String[] argv) {
        ArrayBasedStack arrayBasedStack = new ArrayBasedStack(10);
        arrayBasedStack.push(1);
        arrayBasedStack.push(2);
        arrayBasedStack.push(3);
        arrayBasedStack.push(4);
        arrayBasedStack.push(5);
        arrayBasedStack.push(6);
        arrayBasedStack.push(7);
        arrayBasedStack.push(8);
        arrayBasedStack.push(9);
        arrayBasedStack.push(10);
        arrayBasedStack.push(11);
        arrayBasedStack.push(12);


        for (Integer i : arrayBasedStack)
            System.out.print(i + " ");

        System.out.println();

        System.out.println("arrayBasedStack.pop() -> " + arrayBasedStack.pop());
        System.out.println("arrayBasedStack.pop() -> " + arrayBasedStack.pop());
        System.out.println("arrayBasedStack.pop() -> " + arrayBasedStack.pop());
        System.out.println("arrayBasedStack.pop() -> " + arrayBasedStack.pop());
        System.out.println("arrayBasedStack.pop() -> " + arrayBasedStack.pop());
        System.out.println("arrayBasedStack.pop() -> " + arrayBasedStack.pop());
        System.out.println("arrayBasedStack.pop() -> " + arrayBasedStack.pop());
        System.out.println("arrayBasedStack.pop() -> " + arrayBasedStack.pop());
        System.out.println("arrayBasedStack.pop() -> " + arrayBasedStack.pop());
        for (Integer i : arrayBasedStack)
            System.out.print(i + " ");

    }

    private void resize(int newSize) {
        System.out.println("Resizing array newSize -> " + newSize);
        int[] temp = new int[newSize];
        for (int i = 0; i < counter; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public int pop() {
        if (counter < items.length / 4)
            resize(items.length / 2);
        return items[--counter];
    }

    public void push(int data) {
        if (counter >= items.length) {
            resize(items.length * 2);
        }
        items[counter++] = data;
    }

    @Override
    public Iterator<Integer> iterator() {
        ArrayList<Integer> returnList = new ArrayList<>();
        for (int i = counter - 1; i >= 0; i--) {
            returnList.add(items[i]);
        }
        return returnList.iterator();
    }
}