package com.coursera.ada1.week1;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/5/16.
 */
public class InsertionSortTest extends BaseSortTest {
    InsertionSort insertionSort;

    @Before
    public void setup() {
        insertionSort = new InsertionSort();
    }

    @Test
    public void testInsertionSort() {
        int[] a = new int[]{5, 2, 4, 6, 1, 3};
        insertionSort.sort(a);
        assert super.isSorted(a);
    }


}
