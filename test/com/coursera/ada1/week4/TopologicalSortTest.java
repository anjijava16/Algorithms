package com.coursera.ada1.week4;

import org.junit.Test;

import java.util.List;

/**
 * Created by sunilpatil on 11/25/16.
 */
public class TopologicalSortTest {

    @Test
    public void testSimple() {
        AdjListDirectedGraph graph = new AdjListDirectedGraph();

        Vertex s = graph.addVertex("s");
        Vertex u = graph.addVertex("u");
        Vertex v = graph.addVertex("v");
        Vertex t = graph.addVertex("t");

        graph.addEdge(s, u);
        graph.addEdge(s, v);
        graph.addEdge(u, t);
        graph.addEdge(v, t);

        TopologicalSort topologicalSort = new TopologicalSort(graph);
        topologicalSort.sort();

        List<Vertex> vertexList = graph.getVertexList();
        for (Vertex cv : vertexList)
            System.out.print(cv + " -> ");

        assert graph.getVertex("t").getTopologicalOrder() == 4;
    }

    @Test
    public void testSimple2() {
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
        graph.addEdge(c, f);

        graph.addEdge(a, e);
        graph.addEdge(e, f);
        graph.addEdge(f, d);
        graph.addEdge(b, e);

        TopologicalSort topologicalSort = new TopologicalSort(graph);
        topologicalSort.sort();

        List<Vertex> vertexList = graph.getVertexList();
        for (Vertex cv : vertexList)
            System.out.print(cv + " -> ");

        //   assert graph.getVertex("t").getTopologicalOrder() == 4;
    }
}
