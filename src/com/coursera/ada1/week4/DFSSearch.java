package com.coursera.ada1.week4;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by sunilpatil on 11/22/16.
 */
public class DFSSearch {

    public boolean isConnected(AdjacencyListDirectedGraph graph, int source, int target) {
        boolean connected = false;
        boolean[] visited = new boolean[graph.vertexCount];
        Stack<Integer> verticesQueue = new Stack<>();
        verticesQueue.add(source);
        visited[source] = true;
        while (!verticesQueue.isEmpty()) {
            int currentVertice = verticesQueue.pop();
            System.out.print(" -> " + currentVertice);
            if (currentVertice == target)
                return true;
            Iterator<Integer> edgeListIt = graph.getEdges(currentVertice).iterator();
            while (edgeListIt.hasNext()) {
                int v = edgeListIt.next();
                if (!visited[v]) {
                    visited[v] = true;
                    verticesQueue.push(v);
                }
            }
        }
        return connected;
    }


}
