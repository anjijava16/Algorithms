package com.coursera.ada1.week3;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunilpatil on 11/19/16.
 */
public class AdjancyMetrixGraphTest {
    AdjancyListGraph adjancyMetrixGraph;

    @Before
    public void setup() {
        adjancyMetrixGraph = new AdjancyListGraph(4);
    }

    @Test
    public void testAddEdge() {
        adjancyMetrixGraph.addEdge(1, 2);
        adjancyMetrixGraph.addEdge(1, 3);
        adjancyMetrixGraph.addEdge(1, 4);
        adjancyMetrixGraph.addEdge(2, 4);
        adjancyMetrixGraph.addEdge(3, 4);

        assert adjancyMetrixGraph.isConnected(1, 2) == true;
        assert adjancyMetrixGraph.isConnected(2, 4) == true;
        assert adjancyMetrixGraph.isConnected(2, 3) == false;
    }

    @Test
    public void testRemoveEdge() {
        adjancyMetrixGraph.addEdge(1, 2);
        adjancyMetrixGraph.addEdge(1, 3);
        adjancyMetrixGraph.addEdge(1, 4);
        adjancyMetrixGraph.addEdge(2, 4);
        adjancyMetrixGraph.addEdge(3, 4);

        assert adjancyMetrixGraph.isConnected(1, 2) == true;
        assert adjancyMetrixGraph.isConnected(2, 4) == true;
        assert adjancyMetrixGraph.isConnected(2, 3) == false;

        System.out.println(adjancyMetrixGraph);
        adjancyMetrixGraph.removeEdge(1, 2);
        System.out.println(adjancyMetrixGraph);
        assert adjancyMetrixGraph.isConnected(1, 2) == false;

        adjancyMetrixGraph.removeEdge(1, 4);
        assert adjancyMetrixGraph.isConnected(1, 4) == false;
    }

    @Test
    public void testGetEdges() {
        adjancyMetrixGraph.addEdge(1, 2);
        adjancyMetrixGraph.addEdge(1, 3);
        adjancyMetrixGraph.addEdge(1, 4);
        adjancyMetrixGraph.addEdge(2, 4);
        adjancyMetrixGraph.addEdge(3, 4);

        List<Integer> edges = adjancyMetrixGraph.getEdges(1);
        System.out.println(edges);
        assert edges.size() == 3;
        assert edges.contains(2) && edges.contains(3) && edges.contains(4);

        edges = adjancyMetrixGraph.getEdges(3);
        System.out.println(edges);
        //assert edges.size() == 1;
        // assert edges.contains(1) && edges.contains(4);
    }

    @Test
    public void testEdges() {
        adjancyMetrixGraph.addEdge(1, 2);
        adjancyMetrixGraph.addEdge(1, 3);
        adjancyMetrixGraph.addEdge(1, 4);
        adjancyMetrixGraph.addEdge(2, 4);
        adjancyMetrixGraph.addEdge(3, 4);

        assert adjancyMetrixGraph.edgeList.size() == 5;
        assert adjancyMetrixGraph.edgeList.contains(new Edge(1, 2));

        assert adjancyMetrixGraph.edgeList.contains(new Edge(2, 1));

    }
}
