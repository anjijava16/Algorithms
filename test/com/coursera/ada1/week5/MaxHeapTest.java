package com.coursera.ada1.week5;

import org.junit.Test;

/**
 * Created by sunilpatil on 11/29/16.
 */
public class MaxHeapTest {

    @Test
    public void testMaxInsert() {
        Integer[] a = new Integer[5];
        MaxHeap<Integer> maxHeap = new MaxHeap<>(a);
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(7);

        assert maxHeap.getMax() == 10;
        assert maxHeap.getMax() == 7;
        assert maxHeap.getMax() == 5;
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

        assert maxHeap.getMax() == 13;
        assert maxHeap.getMax() == 12;
        assert maxHeap.getMax() == 11;
        assert maxHeap.getMax() == 9;
        assert maxHeap.getMax() == 9;
        assert maxHeap.getMax() == 8;
        assert maxHeap.getMax() == 6;
        assert maxHeap.getMax() == 5;
        assert maxHeap.getMax() == 4;

    }
}
