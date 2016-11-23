package com.coursera.ada1.week4;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/21/16.
 */
public class BFSSearchTest {
    BFSSearch search;

    @Before
    public void setup() {
        search = new BFSSearch();
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

        assert search.isConnected(graph, 1, 4);
        assert !search.isConnected(graph, 4, 1);

    }

    @Test
    public void testDistance() {
        AdjacencyListDirectedGraph graph = new AdjacencyListDirectedGraph(10);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        assert search.distance(graph, 1, 3) == 2;
        assert search.distance(graph, 1, 4) == 3;
        assert search.distance(graph, 1, 6) == 4;

        assert search.distance(graph, 2, 6) == 3;

        assert search.distance(graph, 1, 7) == -1;

    }

    @Test
    public void testConnectedComponent() {
        AdjacencyListDirectedGraph graph = new AdjacencyListDirectedGraph(11);
        graph.addEdge(1, 3);
        graph.addEdge(1, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 7);
        graph.addEdge(5, 9);

        assert search.connectedComponents(graph) == 6;


        graph.addEdge(2, 4);
        assert search.connectedComponents(graph) == 5;

        graph.addEdge(6, 8);
        graph.addEdge(6, 10);
        assert search.connectedComponents(graph) == 3;

        graph.removeEdge(6, 8);
        assert search.connectedComponents(graph) == 4;

    }
}
