package com.coursera.ada1.week5;

import com.coursera.ada1.week4.AdjListDirectedGraph;
import com.coursera.ada1.week4.Vertex;
import org.junit.Test;

/**
 * Created by sunilpatil on 12/1/16.
 */
public class DijkstraShortestPathTest {
    DijkstraShortestPath dijkstraShortestPath;

    @Test
    public void testSimple() {
        AdjListDirectedGraph adjListDirectedGraph = new AdjListDirectedGraph();
        Vertex s = adjListDirectedGraph.addVertex("s");
        Vertex u = adjListDirectedGraph.addVertex("u");
        Vertex v = adjListDirectedGraph.addVertex("v");
        Vertex t = adjListDirectedGraph.addVertex("t");

        adjListDirectedGraph.addEdge(s, u, 1);
        adjListDirectedGraph.addEdge(s, v, 4);
        adjListDirectedGraph.addEdge(u, v, 2);
        adjListDirectedGraph.addEdge(u, t, 6);
        adjListDirectedGraph.addEdge(v, t, 3);

        dijkstraShortestPath = new DijkstraShortestPath(adjListDirectedGraph);
        dijkstraShortestPath.calculateShortedPath("s");

        assert dijkstraShortestPath.getShortestDistance("t") == 6;
    }
}
