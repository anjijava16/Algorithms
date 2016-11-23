package com.coursera.ada1.week4;

import java.util.Iterator;

/**
 * Created by sunilpatil on 11/23/16.
 */
public class DFSSearchRecursive {

    int source;
    boolean[] marked;
    AdjacencyListDirectedGraph graph;

    public DFSSearchRecursive(AdjacencyListDirectedGraph graph, int source) {
        this.graph = graph;
        this.marked = new boolean[graph.vertexCount];
    }

    public boolean isConnected(int source, int target) {
        return false;
    }

    public Iterator<Integer> pathTo(int target) {
        return null;
    }
}
