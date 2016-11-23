package com.coursera.ada1.week4;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/21/16.
 */
public class AdjacencyListDirectedGraphTest {
    AdjacencyListDirectedGraph adjacencyListDirectedGraph;

    @Before
    public void setup() {
    }

    @Test
    public void testAdd() {
        adjacencyListDirectedGraph = new AdjacencyListDirectedGraph(10);
        adjacencyListDirectedGraph.addEdge(1, 2);
        assert adjacencyListDirectedGraph.connected(1, 2);
        assert !adjacencyListDirectedGraph.connected(2, 1);
    }

    @Test
    public void testGetEdgeList() {
        adjacencyListDirectedGraph = new AdjacencyListDirectedGraph(10);
        adjacencyListDirectedGraph.addEdge(1, 2);
        assert adjacencyListDirectedGraph.getEdges(1).size() == 1;
    }

    @Test
    public void testRemove() {
        adjacencyListDirectedGraph = new AdjacencyListDirectedGraph(10);
        adjacencyListDirectedGraph.addEdge(1, 2);
        adjacencyListDirectedGraph.addEdge(1, 3);
        adjacencyListDirectedGraph.addEdge(1, 4);
        assert adjacencyListDirectedGraph.connected(1, 4);

        adjacencyListDirectedGraph.removeEdge(1, 4);
        assert !adjacencyListDirectedGraph.connected(1, 4);

    }
}
