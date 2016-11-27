package com.coursera.ada1.week4;

import org.junit.Test;

import java.util.List;

/**
 * Created by sunilpatil on 11/25/16.
 */
public class DFSSearchDirectedGraphTest {

    @Test
    public void testDFS() {
        AdjListDirectedGraph graph = new AdjListDirectedGraph();
        Vertex s = graph.addVertex("s");
        Vertex u = graph.addVertex("u");
        Vertex v = graph.addVertex("v");
        Vertex t = graph.addVertex("t");

        graph.addEdge("s", "u");
        graph.addEdge("s", "v");
        graph.addEdge("u", "t");
        graph.addEdge("v", "t");

        DFSSearchDirectedGraph DFSSearchDirectedGraph = new DFSSearchDirectedGraph(graph);
        DFSSearchDirectedGraph.dfs(s);
    }

    @Test
    public void testAddPath() {
        AdjListDirectedGraph graph = new AdjListDirectedGraph();
        Vertex s = graph.addVertex("s");
        Vertex u = graph.addVertex("u");
        Vertex v = graph.addVertex("v");
        Vertex t = graph.addVertex("t");

        graph.addEdge("s", "u");
        graph.addEdge("s", "v");
        graph.addEdge("u", "t");
        graph.addEdge("v", "t");

        DFSSearchDirectedGraph DFSSearchDirectedGraph = new DFSSearchDirectedGraph(graph);
        List<Vertex> pathList = DFSSearchDirectedGraph.getPath(s, t);
        System.out.println();
        for (Vertex vertex : pathList)
            System.out.print(vertex + " -> ");
        System.out.println();

        assert DFSSearchDirectedGraph.getPath(s, t).size() == 2;
    }

    @Test
    public void testAddPath2() {
        AdjListDirectedGraph graph = new AdjListDirectedGraph();
        Vertex a = graph.addVertex("A");
        Vertex b = graph.addVertex("B");
        Vertex c = graph.addVertex("C");
        Vertex d = graph.addVertex("D");
        Vertex e = graph.addVertex("E");
        Vertex f = graph.addVertex("F");


        graph.addEdge(a, b);
        graph.addEdge(b, c);
        graph.addEdge(c, d);
        graph.addEdge(a, e);
        graph.addEdge(e, f);
        graph.addEdge(f, d);

        DFSSearchDirectedGraph DFSSearchDirectedGraph = new DFSSearchDirectedGraph(graph);
        List<Vertex> pathList = DFSSearchDirectedGraph.getPath(a, d);
        System.out.println("Start of path list");
        for (Vertex vertex : pathList)
            System.out.print(vertex + " -> ");
        System.out.println("End of path list");
    }
}
