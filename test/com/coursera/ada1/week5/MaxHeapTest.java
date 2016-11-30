package com.coursera.ada1.week5;

import org.junit.Test;

/**
 * Created by sunilpatil on 11/29/16.
 */
public class MaxHeapTest {
    @Test
    public void testSimple() {
        Integer[] a = new Integer[5];
        MaxHeap<Integer> maxHeap = new MaxHeap<>(a);
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(7);

        assert maxHeap.getMin() == 10;
        assert maxHeap.getMin() == 7;
        assert maxHeap.getMin() == 5;
    }

    @Test
    public void testSimple2() {
        Integer[] a = new Integer[10];
        MaxHeap<Integer> maxHeap = new MaxHeap<>(a);
        maxHeap.insert(11);
        maxHeap.insert(13);
        maxHeap.insert(9);
        maxHeap.insert(4);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.insert(8);
        maxHeap.insert(12);
        maxHeap.insert(9);

        assert maxHeap.getMin() == 13;
        assert maxHeap.getMin() == 12;
        assert maxHeap.getMin() == 11;
        assert maxHeap.getMin() == 9;
        assert maxHeap.getMin() == 9;
        assert maxHeap.getMin() == 8;
        assert maxHeap.getMin() == 6;
        assert maxHeap.getMin() == 5;
        assert maxHeap.getMin() == 4;

    }
}
