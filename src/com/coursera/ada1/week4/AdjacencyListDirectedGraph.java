package com.coursera.ada1.week4;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunilpatil on 11/21/16.
 */
public class AdjacencyListDirectedGraph {

    List<Integer>[] vertices;
    int vertexCount;

    public AdjacencyListDirectedGraph(int vertextCount) {
        this.vertexCount = vertextCount;
        vertices = new List[vertextCount];
        for (int i = 0; i < vertextCount; i++) {
            vertices[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        vertices[source].add(destination);
    }

    public void removeEdge(int source, int target) {
        vertices[source].remove(new Integer(target));
    }

    public boolean connected(int source, int target) {
        if (vertices[source].contains(new Integer(target)))
            return true;

        return false;
    }

    public List getEdges(int source) {
        return vertices[source];
    }
}
