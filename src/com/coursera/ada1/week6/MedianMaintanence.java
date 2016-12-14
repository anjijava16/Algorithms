package com.coursera.ada1.week6;

import com.coursera.ada1.week5.MaxHeap;
import com.coursera.ada1.week5.MinHeap;

/**
 * Created by sunilpatil on 12/8/16.
 */
public class MedianMaintanence {
    MinHeap<Integer> upperHeap;
    MaxHeap<Integer> lowerHeap;
    int currentMedian;

    public MedianMaintanence(int capacity) {
        Integer[] upperHeapA = new Integer[capacity / 2 + 2];
        upperHeap = new MinHeap<Integer>(upperHeapA);

        Integer[] lowerHeapA = new Integer[capacity / 2 + 2];
        lowerHeap = new MaxHeap<Integer>(lowerHeapA);
    }


    public void insert(int newNo) {
        if (upperHeap.getSize() == 0) {
            upperHeap.insert(newNo);
            currentMedian = newNo;
            return;
        }

        //First insert in appropriate heap based on value of new element
        if (newNo >= upperHeap.peek())
            upperHeap.insert(newNo);
        else
            lowerHeap.insert(newNo);


        //Re-balance the heap to make sure that in case of odd size the upper heap has more elements
        if (upperHeap.getSize() > lowerHeap.getSize() + 1) {
            lowerHeap.insert(upperHeap.getMin());
        } else if (lowerHeap.getSize() > upperHeap.getSize()) {
            upperHeap.insert(lowerHeap.getMax());
        }

        //Calculate current median
        if (upperHeap.getSize() > lowerHeap.getSize()) {
            currentMedian = upperHeap.peek();
        } else {
            currentMedian = lowerHeap.peek();
        }

    }

    public int getCurrentMedian() {
        // System.out.println("Current Median " + currentMedian);
        return currentMedian;
    }

    public void setCurrentMedian(int currentMedian) {
        this.currentMedian = currentMedian;
    }
}
