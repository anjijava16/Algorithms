package com.coursera.ada1.week6;

import org.junit.Test;

/**
 * Created by sunilpatil on 12/8/16.
 */
public class MedianMaintanenceTest {

    @Test
    public void testSimple() {
        MedianMaintanence medianMaintanence = new MedianMaintanence(10);
        medianMaintanence.insert(8);
        assert medianMaintanence.getCurrentMedian() == 8;

        medianMaintanence.insert(4);
        assert medianMaintanence.getCurrentMedian() == 4;

        medianMaintanence.insert(5);
        assert medianMaintanence.getCurrentMedian() == 5;

        medianMaintanence.insert(9);
        assert medianMaintanence.getCurrentMedian() == 5;

        medianMaintanence.insert(10);
        assert medianMaintanence.getCurrentMedian() == 8;
    }

    @Test
    public void testAscending() {
        MedianMaintanence medianMaintanence = new MedianMaintanence(10);

        medianMaintanence.insert(2);
        assert medianMaintanence.getCurrentMedian() == 2;

        medianMaintanence.insert(4);
        assert medianMaintanence.getCurrentMedian() == 2;

        medianMaintanence.insert(6);
        assert medianMaintanence.getCurrentMedian() == 4;

        medianMaintanence.insert(8);
        assert medianMaintanence.getCurrentMedian() == 4;

        medianMaintanence.insert(10);
        assert medianMaintanence.getCurrentMedian() == 6;
    }

    @Test
    public void testDescending() {
        MedianMaintanence medianMaintanence = new MedianMaintanence(10);

        medianMaintanence.insert(10);
        assert medianMaintanence.getCurrentMedian() == 10;

        medianMaintanence.insert(8);
        assert medianMaintanence.getCurrentMedian() == 8;

        medianMaintanence.insert(6);
        assert medianMaintanence.getCurrentMedian() == 8;

        medianMaintanence.insert(4);
        assert medianMaintanence.getCurrentMedian() == 6;

        medianMaintanence.insert(2);
        assert medianMaintanence.getCurrentMedian() == 6;
    }

}
