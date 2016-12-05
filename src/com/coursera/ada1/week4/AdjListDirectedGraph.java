package com.coursera.ada1.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sunilpatil on 11/24/16.
 */
public class AdjListDirectedGraph {

    HashMap<String, Vertex> vertexHashMap;
    private List<Vertex> vertexList;

    public AdjListDirectedGraph() {
        this.vertexList = new ArrayList<>();
        this.vertexHashMap = new HashMap<>();
    }

    public Vertex addVertex(String label) {
        //if (containsVertex(label))
        //    return getVertex(label);
        Vertex v = new Vertex(label);
        this.vertexList.add(v);
        this.vertexHashMap.put(label, v);
        return v;
    }

    public Vertex getVertex(String source) {
        return vertexHashMap.get(source);
    }

    public boolean containsVertex(String label) {
        return vertexList.contains(new Vertex(label));

    }

    public void addEdge(String source, String target) {
        Vertex sourceVertex = getVertex(source);
        Vertex targetVertex = getVertex(target);
        this.addEdge(sourceVertex, targetVertex);
    }

    public void addEdge(Vertex sourceVertex, Vertex targetVertex) {
        Edge edge = new Edge();
        edge.setSource(sourceVertex);
        edge.setTarget(targetVertex);
        sourceVertex.getEdgeList().add(edge);
    }

    public void addEdge(String source, String target, int weight) {
        Vertex sourceVertex = getVertex(source);
        Vertex targetVertex = getVertex(target);
        this.addEdge(sourceVertex, targetVertex, weight);
    }

    public void addEdge(Vertex sourceVertex, Vertex targetVertex, int weight) {
        Edge edge = new Edge();
        edge.setSource(sourceVertex);
        edge.setTarget(targetVertex);
        edge.setWeight(weight);
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


    public void printGraph() {
        for (Vertex v : vertexList) {
            System.out.println(v.getLabel() + ", " + v.getTopologicalOrder() + " -> " + v.getEdgeList());
        }
    }
}
