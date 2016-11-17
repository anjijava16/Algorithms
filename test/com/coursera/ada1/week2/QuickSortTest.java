package com.coursera.ada1.week2;

import com.coursera.ada1.week1.BaseSortTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sunilpatil on 11/10/16.
 */
public class QuickSortTest extends BaseSortTest {
    QuickSort quickSort;

    @Before
    public void setup() {
        quickSort = new QuickSort();
    }

    @Test
    public void testMergeSort() {
        int[] input = new int[]{6, 3, 7, 1, 8, 4, 2, 5};
        quickSort.quicksort(input);
        System.out.println(Arrays.toString(input));
        assert super.isSorted(input);
    }

    @Test
    public void testQuickSort() {
        int[] input = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        quickSort.quicksort(input);
        System.out.println(Arrays.toString(input));
        assert super.isSorted(input);
    }

    @Test
    public void testReversedArray() {
        int[] input = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        quickSort.quicksort(input);
        System.out.println(Arrays.toString(input));
        assert super.isSorted(input);
    }

    @Test
    public void testPreSortedArray() {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        quickSort.quicksort(input);
        System.out.println(Arrays.toString(input));
        assert super.isSorted(input);
    }

    @Test
    public void testModArray() {
        int[] input = new int[]{1, 2, 3, 4, 8, 7, 6, 5};
        quickSort.quicksort(input);
        System.out.println(Arrays.toString(input));
        assert super.isSorted(input);
    }

    @Test
    public void testWithDuplicates() {
        int[] input = new int[]{1, 2, 3, 4, 4, 3, 6, 5};
        quickSort.quicksort(input);
        System.out.println(Arrays.toString(input));
        assert super.isSorted(input);
    }
}
