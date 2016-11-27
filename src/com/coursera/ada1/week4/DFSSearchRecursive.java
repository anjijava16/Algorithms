package com.coursera.ada1.week4;

import java.util.Iterator;
import java.util.List;

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
        this.source = source;
        search(source);
    }

    public void search(int source) {
        System.out.print(source + " -> ");
        if (marked[source] == true)
            return;
        marked[source] = true;
        List<Integer> edges = graph.getEdges(source);
        for (int i = 0; i < edges.size(); i++) {
            int t = edges.get(i);
            if (marked[t] == false)
                search(t);
        }
    }

    public boolean isConnected(int target) {
        return marked[target];
    }

    public Iterator<Integer> pathTo(int target) {
        return null;
    }
}
