package com.coursera.ada1.week1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sunilpatil on 11/4/16.
 */
public class MergeSortTest extends BaseSortTest {
    MergeSort mergeSort;

    @Before
    public void setup() {
        mergeSort = new MergeSort();
    }

    @Test
    public void testMergeSort() {
        int[] input = new int[]{6, 3, 7, 1, 8, 4, 2, 5};
        mergeSort.sort(input);
        System.out.println(Arrays.toString(input));
        assert super.isSorted(input);
    }


}
