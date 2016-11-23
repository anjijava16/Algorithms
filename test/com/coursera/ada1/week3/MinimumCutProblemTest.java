package com.coursera.ada1.week3;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/19/16.
 */
public class MinimumCutProblemTest {
    MinimumCutProblem minimumCutProblem;

    @Before
    public void setup() {
        minimumCutProblem = new MinimumCutProblem();
    }

    @Test
    public void testSimple() {
        AdjancyListGraph inputGraph = new AdjancyListGraph(4);

        inputGraph.addEdge(1, 2);
        inputGraph.addEdge(1, 3);
        inputGraph.addEdge(2, 3);
        inputGraph.addEdge(2, 4);
        inputGraph.addEdge(3, 4);
        System.out.println(inputGraph);

        int minCut = minimumCutProblem.calculateMinCut(inputGraph);

        System.out.println("Value of min cut " + minCut);

    }

    @Test
    public void testSimple2() {
        AdjancyListGraph inputGraph = new AdjancyListGraph(8);

        inputGraph.addEdge(1, 2);
        inputGraph.addEdge(1, 3);
        inputGraph.addEdge(1, 4);
        inputGraph.addEdge(2, 3);
        inputGraph.addEdge(2, 4);
        inputGraph.addEdge(3, 4);

        inputGraph.addEdge(2, 5);
        inputGraph.addEdge(4, 7);

        inputGraph.addEdge(5, 6);
        inputGraph.addEdge(5, 8);
        inputGraph.addEdge(5, 7);
        inputGraph.addEdge(6, 8);
        inputGraph.addEdge(6, 7);
        inputGraph.addEdge(7, 8);


        System.out.println(inputGraph);


        int minCut = minimumCutProblem.calculateMinCut(inputGraph);

        System.out.println("Value of min cut " + minCut);

    }
}
