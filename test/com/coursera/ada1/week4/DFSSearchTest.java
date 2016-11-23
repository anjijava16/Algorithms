package com.coursera.ada1.week4;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/22/16.
 */
public class DFSSearchTest {
    DFSSearch search;

    @Before
    public void setup() {
        search = new DFSSearch();
    }

    @Test
    public void testSearch() {
        AdjacencyListDirectedGraph graph = new AdjacencyListDirectedGraph(10);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        assert search.isConnected(graph, 1, 5);
        System.out.println();
        assert search.isConnected(graph, 1, 6);
        System.out.println();

        assert !search.isConnected(graph, 6, 1);
        System.out.println();
        assert search.isConnected(graph, 1, 4);

    }
}
