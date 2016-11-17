package com.introtoalg.chapter9;


import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/15/16.
 */
public class FindMinMaxSimultTest {
    FindMinMaxSimult findMinMaxSimult;

    @Before
    public void setup() {
        findMinMaxSimult = new FindMinMaxSimult();
    }

    @Test
    public void testBasic() {
        int[] a = findMinMaxSimult.findMinMax2(new int[]{5, 4, 1, 8, 6, 3, 2, 7});
        assert a.length == 2;
        assert a[0] == 1;
        assert a[1] == 8;

        System.out.println("Number of comparisions " + findMinMaxSimult.comparisions);
    }

    @Test
    public void testArrayWithSameNumber() {
        int[] a = findMinMaxSimult.findMinMax2(new int[]{5, 5, 5, 5, 5, 5});
        assert a.length == 2;
        assert a[0] == 5;
        assert a[1] == 5;
    }

    @Test
    public void testOddNumbers() {
        int[] a = findMinMaxSimult.findMinMax2(new int[]{5, 4, 1, 8, 6, 3, 0, 9});
        assert a.length == 2;
        assert a[0] == 0;
        assert a[1] == 9;

        System.out.println("Number of comparisions " + findMinMaxSimult.comparisions);
    }
}
