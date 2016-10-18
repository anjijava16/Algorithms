package com.cci;

import java.util.ArrayList;

/**
 * Created by sunilpatil on 10/18/16.
 */
public class SetOfStacks {
    private static final int MAX_STACk_SIZE = 5;
    ArrayList<Stack> arrayList = new ArrayList<>();
    Stack currentStack;

    public SetOfStacks() {
        currentStack = new Stack();
        arrayList.add(currentStack);

    }

    public static void main(String[] argv) {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.push(7);
        setOfStacks.push(8);

        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
    }

    public int pop() {
        if (currentStack.getSize() == 0) {
            arrayList.remove(arrayList.size() - 1);
            currentStack = arrayList.get(arrayList.size() - 1);
        }
        return currentStack.pop();
    }

    public void push(int n) {

        if (currentStack.getSize() >= MAX_STACk_SIZE) {
            Stack newStack = new Stack();
            arrayList.add(newStack);
            currentStack = newStack;
        }
        currentStack.push(n);
    }
}