package com.coursera.ada1.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilpatil on 11/24/16.
 */
public class AdjListDirectedGraph {

    private List<Vertex> vertexList;

    public AdjListDirectedGraph() {
        this.vertexList = new ArrayList<>();
    }

    public Vertex addVertex(String label) {
        if (containsVertex(label))
            return getVertex(label);
        Vertex v = new Vertex(label);
        this.vertexList.add(v);
        return v;
    }

    public Vertex getVertex(String source) {
        for (Vertex v : vertexList) {
            if (v.getLabel().equals(source)) {
                return v;
            }
        }
        return null;
    }

    public boolean containsVertex(String label) {
        return vertexList.contains(new Vertex(label));

    }

    public void addEdge(String source, String target) {
        if (!containsVertex(source) || !containsVertex(target))
            return;
        Vertex sourceVertex = getVertex(source);
        Vertex targetVertex = getVertex(target);
        Edge edge = new Edge();
        edge.setSource(sourceVertex);
        edge.setTarget(targetVertex);
        sourceVertex.getEdgeList().add(edge);

    }

    public void addEdge(Vertex sourceVertex, Vertex targetVertex) {
        Edge edge = new Edge();
        edge.setSource(sourceVertex);
        edge.setTarget(targetVertex);
        sourceVertex.getEdgeList().add(edge);
    }

    public List<Edge> getEdgeList(String source) {
        if (containsVertex(source)) {
            for (Vertex v : vertexList) {
                if (v.getLabel().equals(source)) {
                    return v.getEdgeList();
                }
            }
        }
        return null;
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public int getVertexCount() {
        return this.vertexList.size();
    }
}
