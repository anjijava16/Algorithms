package com.coursera.ada1.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilpatil on 11/24/16.
 */
public class Vertex {
    public List<Edge> edgeList;
    private String label;
    private int topologicalOrder;

    public Vertex(String label) {
        this.label = label;
        edgeList = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edgeList.add(edge);
    }

    public void removeEdge(Edge edge) {
        edgeList.remove(edge);
    }

    public boolean contains(Edge edge) {
        return edgeList.contains(edge);
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getTopologicalOrder() {
        return topologicalOrder;
    }

    public void setTopologicalOrder(int topologicalOrder) {
        this.topologicalOrder = topologicalOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return label.equals(vertex.label);
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    @Override
    public String toString() {
        return "{ " +
                label + " " + topologicalOrder +
                " }";
    }
}
