package com.coursera.ada1.week5;

import org.junit.Test;

/**
 * Created by sunilpatil on 11/29/16.
 */
public class MinHeapTest {

    @Test
    public void testSimple() {
        Integer[] a = new Integer[5];
        MinHeap<Integer> minHeap = new MinHeap<>(a);
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(7);

        assert minHeap.getMin() == 5;

        assert minHeap.getMin() == 7;

        assert minHeap.getMin() == 10;
    }

    @Test
    public void testSimple2() {
        Integer[] a = new Integer[10];
        MinHeap<Integer> minHeap = new MinHeap<>(a);
        minHeap.insert(11);
        minHeap.insert(13);
        minHeap.insert(9);
        minHeap.insert(4);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(8);
        minHeap.insert(12);
        minHeap.insert(9);


        assert minHeap.getMin() == 4;

        assert minHeap.getMin() == 5;
        assert minHeap.getMin() == 6;
        assert minHeap.getMin() == 8;
        assert minHeap.getMin() == 9;
        assert minHeap.getMin() == 9;
        assert minHeap.getMin() == 11;
        assert minHeap.getMin() == 12;
        assert minHeap.getMin() == 13;


    }
}
