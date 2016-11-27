package com.coursera.ada1.week4;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/24/16.
 */
public class DFSSearchRecursiveTest {

    DFSSearchRecursive search;

    @Before
    public void setup() {
    }

    @Test
    public void testIsConnected() {
        AdjacencyListDirectedGraph graph = new AdjacencyListDirectedGraph(10);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        search = new DFSSearchRecursive(graph, 1);
        assert search.isConnected(3) == true;
        System.out.println();
        assert search.isConnected(7) == false;
    }
}
