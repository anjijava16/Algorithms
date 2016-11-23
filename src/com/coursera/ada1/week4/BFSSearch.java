package com.coursera.ada1.week4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sunilpatil on 11/21/16.
 */
public class BFSSearch {

    public boolean isConnected(AdjacencyListDirectedGraph graph, int source, int target) {

        boolean connected = false;
        boolean[] visited = new boolean[graph.vertexCount];
        Queue<Integer> verticesQueue = new LinkedList<>();
        verticesQueue.add(source);
        visited[source] = true;
        while (!verticesQueue.isEmpty()) {
            int currentVertice = verticesQueue.poll();
            System.out.print(" -> " + currentVertice);
            if (currentVertice == target)
                return true;

            Iterator<Integer> edgeListIt = graph.getEdges(currentVertice).iterator();
            while (edgeListIt.hasNext()) {
                int v = edgeListIt.next();
                if (!visited[v]) {
                    visited[v] = true;
                    verticesQueue.add(v);
                }

            }
        }

        return connected;
    }

    public int distance(AdjacencyListDirectedGraph graph, int source, int target) {
        int distance = -1;

        int[] d = new int[graph.vertexCount];
        Queue<Integer> verticesQueue = new LinkedList<Integer>();
        verticesQueue.add(source);
        d[source] = 1;
        while (!verticesQueue.isEmpty()) {
            int currentVertice = verticesQueue.poll();
            if (currentVertice == target)
                return d[currentVertice];

            Iterator<Integer> edgeListIt = graph.getEdges(currentVertice).iterator();
            while (edgeListIt.hasNext()) {
                int v = edgeListIt.next();
                if (d[v] == 0) {
                    d[v] = d[currentVertice] + 1;
                    verticesQueue.add(v);
                }

            }
        }
        return distance;
    }

    public int connectedComponents(AdjacencyListDirectedGraph graph) {
        int[] ccId = new int[graph.vertexCount];
        int connectedComponentCounter = 0;
        for (int i = 1; i < graph.vertexCount; i++) {
            if (ccId[i] != 0)
                continue;
            Queue<Integer> verticesQueue = new LinkedList<Integer>();
            verticesQueue.add(i);
            ccId[i] = ++connectedComponentCounter;
            while (!verticesQueue.isEmpty()) {
                int currentVertice = verticesQueue.poll();
                Iterator<Integer> edgeListIt = graph.getEdges(currentVertice).iterator();
                while (edgeListIt.hasNext()) {
                    int v = edgeListIt.next();
                    if (ccId[v] == 0) {
                        ccId[v] = connectedComponentCounter;
                        verticesQueue.add(v);
                    }
                }
            }
        }
        return connectedComponentCounter;
    }
}
