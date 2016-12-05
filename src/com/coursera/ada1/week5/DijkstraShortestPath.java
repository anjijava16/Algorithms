package com.coursera.ada1.week5;

import com.coursera.ada1.week4.AdjListDirectedGraph;
import com.coursera.ada1.week4.Edge;
import com.coursera.ada1.week4.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by sunilpatil on 12/1/16.
 */
public class DijkstraShortestPath {
    AdjListDirectedGraph adjListDirectedGraph;
    MinHeap<VertexDistance> distanceHeap;
    HashSet<Vertex> X;
    HashMap<Vertex, Integer> currentDistances;

    DijkstraShortestPath(AdjListDirectedGraph adjListDirectedGraph) {
        this.adjListDirectedGraph = adjListDirectedGraph;
    }

    public void calculateShortedPath(String source) {
        Vertex sourceVertex = adjListDirectedGraph.getVertex(source);

        this.calculateShortedPath(sourceVertex);
    }

    public void calculateShortedPath(Vertex sourceVertex) {
        X = new HashSet();
        currentDistances = new HashMap<>();

        distanceHeap = new MinHeap(new VertexDistance[300000]);
        X.add(sourceVertex);
        currentDistances.put(sourceVertex, 0);

        while (X.size() < adjListDirectedGraph.getVertexCount()) {
            HashMap<Vertex, Integer> vertexDistanceMap = new HashMap<>();
            for (Vertex c : X) {
                int currentVertexDistance = currentDistances.get(c);
                List<Edge> edgeList = c.getEdgeList();
                for (Edge edge : edgeList) {
                    int dijkstarDistance = currentVertexDistance + edge.getWeight();
                    distanceHeap.insert(new VertexDistance(edge.getTarget(), dijkstarDistance));
                }
            }

            VertexDistance min = distanceHeap.getMin();
            System.out.println("Value of min " + min);
            if (min == null || X == null || distanceHeap == null)
                return;
            while (X.contains(min.v)) {
                min = distanceHeap.getMin();
                if (min == null)
                    return;
            }
            //  if(min.v == targetVertex)
            //      return min.distance;
            System.out.println("Found min. distance for " + min.v + " -> " + min.distance);
            X.add(min.v);
            currentDistances.put(min.v, min.distance);

        }
    }

    public int getShortestDistance(String target) {
        Vertex targetVertex = adjListDirectedGraph.getVertex(target);
        return currentDistances.get(targetVertex);
    }

    public static class VertexDistance implements Comparable<VertexDistance> {
        Vertex v;
        int distance;

        public VertexDistance(Vertex v, int distance) {
            this.v = v;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "VertexDistance{" +
                    "v=" + v +
                    ", distance=" + distance +
                    '}';
        }

        @Override
        public int compareTo(VertexDistance o) {
            if (o.distance < this.distance)
                return 1;

            return -1;
        }
    }
}
