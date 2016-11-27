package com.coursera.ada1.week4;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by sunilpatil on 11/25/16.
 */
public class DFSSearchDirectedGraph {

    private AdjListDirectedGraph graph;

    DFSSearchDirectedGraph(AdjListDirectedGraph graph) {
        this.graph = graph;
    }

    public void dfs(Vertex source) {
        HashMap<Vertex, Boolean> marked = new HashMap<>();
        Stack<Vertex> vertices = new Stack<>();
        marked.put(source, true);
        vertices.push(source);

        while (!vertices.empty()) {
            Vertex currentVertex = vertices.pop();
            System.out.print(currentVertex + " -> ");

            List<Edge> edgeList = currentVertex.getEdgeList();
            for (Edge edge : edgeList) {
                if (marked.get(edge.getTarget()) == null) {
                    vertices.push(edge.getTarget());
                    marked.put(edge.getTarget(), true);
                }
            }
        }
    }

    public Stack<Vertex> getPath(Vertex source, Vertex target) {
        HashMap<Vertex, Boolean> marked = new HashMap<>();
        Stack<Vertex> vertices = new Stack<>();
        marked.put(source, true);
        vertices.push(source);

        while (!vertices.empty()) {
            Vertex currentVertex = vertices.pop();
            if (currentVertex == target) {
                vertices.push(currentVertex);
                return vertices;
            }
            System.out.print(currentVertex + " -> ");

            List<Edge> edgeList = currentVertex.getEdgeList();
            for (Edge edge : edgeList) {
                if (marked.get(edge.getTarget()) == null) {
                    vertices.push(edge.getTarget());
                    marked.put(edge.getTarget(), true);
                }
            }
        }
        return null;
    }

}
