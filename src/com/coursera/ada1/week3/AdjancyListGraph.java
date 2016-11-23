package com.coursera.ada1.week3;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunilpatil on 11/19/16.
 */
public class AdjancyListGraph {

    List<Edge> edgeList;
    List<Integer>[] vertices;
    int vertexCount;

    public AdjancyListGraph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.edgeList = new LinkedList<>();
        vertices = new List[vertexCount + 1];
        for (int i = 0; i <= vertexCount; i++) {
            vertices[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        if (source != destination) {
            if (vertices[source].contains(new Integer(destination)) == false) {
                vertices[source].add(destination);
                edgeList.add(new Edge(source, destination));
            }
        }
    }

    public void removeEdge(int source, int destination) {
        if (isConnected(source, destination)) {
            vertices[source].remove(new Integer(destination));
        }
    }

    public boolean isConnected(int source, int destination) {
        if (vertices[source].contains(destination))
            return true;
        return false;
    }

    public List<Integer> getEdges(int source) {
        return vertices[source];
    }

    public int getNumberOfVertices() {
        int count = 0;
        for (List v : vertices) {
            if (v.size() != 0)
                count++;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < vertices.length; i++) {
            stringBuffer.append(i + " -> " + vertices[i] + "\n");
        }
        return stringBuffer.toString();
    }
}
