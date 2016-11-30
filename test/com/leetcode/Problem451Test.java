package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/29/16.
 */
public class Problem451Test {
    Problem451 problem;

    @Before
    public void setup() {
        problem = new Problem451();
    }

    @Test
    public void testSimple() {
        Problem451 problem = new Problem451();
        String s = problem.frequencySort("tree");
        System.out.println("Return value " + s);
        assert s.equals("eetr") || s.equals("eert");

    }

    @Test
    public void testSimple1() {
        Problem451 problem = new Problem451();
        String s = problem.frequencySort("cccaaa");
        System.out.println("Return value " + s);
        assert s.equals("cccaaa") || s.equals("aaaccc");

    }

    @Test
    public void testSimple2() {
        Problem451 problem = new Problem451();
        String s = problem.frequencySort("Aabb");
        System.out.println("Return value " + s);
        assert s.equals("bbAa");

    }

    @Test
    public void testSimple3() {
        Problem451 problem = new Problem451();
        String s = problem.frequencySort("");
        System.out.println("Return value " + s);
        assert s.equals("");

    }

    @Test
    public void testSimple4() {
        Problem451 problem = new Problem451();
        String s = problem.frequencySort("a");
        System.out.println("Return value " + s);
        assert s.equals("a");

    }
}
