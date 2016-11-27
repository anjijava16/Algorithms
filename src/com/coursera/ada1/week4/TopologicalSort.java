package com.coursera.ada1.week4;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Created by sunilpatil on 11/25/16.
 */
public class TopologicalSort {
    AdjListDirectedGraph graph;
    HashSet<Vertex> marked;
    private int currentLabel;

    public TopologicalSort(AdjListDirectedGraph graph) {
        this.graph = graph;
        marked = new HashSet<>();
        currentLabel = graph.getVertexCount();
    }

    public void sort() {
        List<Vertex> vertexList = graph.getVertexList();

        for (Vertex v : vertexList) {
            if (marked.contains(v) == false) {
                dfsR(v);
                v.setTopologicalOrder(currentLabel--);
            }
        }
    }

    public void dfsR(Vertex source) {
        if (marked.contains(source))
            return;
        marked.add(source);
        List<Edge> edgeList = source.getEdgeList();
        for (Edge edge : edgeList) {
            dfsR(edge.getTarget());
        }
        source.setTopologicalOrder(currentLabel--);
    }

    public void dfs(Vertex source) {
        Stack<Vertex> vertices = new Stack<>();
        marked.add(source);
        vertices.push(source);

        while (!vertices.empty()) {
            Vertex currentVertex = vertices.pop();
            if (!currentVertex.equals(source))
                currentVertex.setTopologicalOrder(currentLabel--);
            System.out.print(currentVertex + " -> ");

            List<Edge> edgeList = currentVertex.getEdgeList();
            for (Edge edge : edgeList) {
                if (!marked.contains(edge.getTarget())) {
                    vertices.push(edge.getTarget());
                    marked.add(edge.getTarget());
                }
            }
        }
    }
}
