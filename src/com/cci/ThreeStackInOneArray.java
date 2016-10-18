package com.cci;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Describe how you could use a single array to implement three stacks
 * Created by sunilpatil on 10/17/16.
 */
public class ThreeStackInOneArray {
    int[] a;
    int[] pointers;

    public ThreeStackInOneArray(int size) {
        a = new int[size * 3];
        pointers = new int[3];
        pointers[0] = 0;
        pointers[1] = size;
        pointers[2] = size * 2;
    }

    public static void main(String[] argv) {
        ThreeStackInOneArray threeStackInOneArray = new ThreeStackInOneArray(10);
        threeStackInOneArray.push(0, 1);
        threeStackInOneArray.push(0, 2);
        threeStackInOneArray.push(0, 3);
        System.out.println(threeStackInOneArray.pop(0));

        threeStackInOneArray.printStack(0);
        threeStackInOneArray.printStack(1);
        threeStackInOneArray.printStack(2);


        threeStackInOneArray.push(1, 11);
        threeStackInOneArray.push(1, 12);
        threeStackInOneArray.push(1, 13);
        System.out.println(threeStackInOneArray.pop(1));
        threeStackInOneArray.printStack(0);
        threeStackInOneArray.printStack(1);
        threeStackInOneArray.printStack(2);

        threeStackInOneArray.push(2, 21);
        threeStackInOneArray.push(2, 22);
        threeStackInOneArray.push(2, 23);
        System.out.println(threeStackInOneArray.pop(2));

        threeStackInOneArray.printStack(0);
        threeStackInOneArray.printStack(1);
        threeStackInOneArray.printStack(2);
    }

    public int pop(int stackNo) {
        return a[--pointers[stackNo]];
    }

    public void push(int stackNo, int data) {
        a[pointers[stackNo]++] = data;

    }

    public Iterator<Integer> iterator(int stackNo) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int start = pointers[stackNo] - 1;
        int endSize = 0;
        if (stackNo == 1)
            endSize = 10;
        else if (stackNo == 2)
            endSize = 20;

        for (int i = start; i >= endSize; i--) {
            integerArrayList.add(a[i]);
        }
        return integerArrayList.iterator();
    }

    private void printStack(int stackNo) {
        System.out.println("Stack No -> " + stackNo);
        Iterator<Integer> stackIt = this.iterator(stackNo);
        while (stackIt.hasNext()) {
            System.out.print(stackIt.next() + " ");
        }
        System.out.println();
    }
}
