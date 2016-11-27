package com.coursera.ada1.week4;

import org.junit.Test;

/**
 * Created by sunilpatil on 11/24/16.
 */
public class AdjListDirectedGraphTest {

    @Test
    public void addVertexTest() {
        AdjListDirectedGraph graph = new AdjListDirectedGraph();
        graph.addVertex("s");
        assert graph.getVertexCount() == 1;
        graph.addVertex("u");
        assert graph.getVertexCount() == 2;

    }

    @Test
    public void addEdgeTest() {
        AdjListDirectedGraph graph = new AdjListDirectedGraph();
        graph.addVertex("s");
        assert graph.getVertexCount() == 1;
        graph.addVertex("u");
        assert graph.getVertexCount() == 2;

        graph.addEdge("s", "u");

        assert graph.getEdgeList("s").size() == 1;

    }
}
