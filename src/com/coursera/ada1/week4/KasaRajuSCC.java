package com.coursera.ada1.week4;

import java.util.List;

/**
 * Created by sunilpatil on 11/25/16.
 */
public class KasaRajuSCC {
    AdjListDirectedGraph graph;

    public KasaRajuSCC(AdjListDirectedGraph graph) {
        this.graph = graph;
    }

    AdjListDirectedGraph reverse(AdjListDirectedGraph graph) {

        AdjListDirectedGraph reverseGraph = new AdjListDirectedGraph();
        List<Vertex> vertexList = graph.getVertexList();
        for (Vertex vertex : vertexList) {
            reverseGraph.addVertex(vertex.getLabel());
        }

        for (Vertex vertex : vertexList) {
            List<Edge> edgeList = vertex.getEdgeList();
            for (Edge edge : edgeList) {
                Vertex sourceVertex = edge.getSource();
                Vertex targetVertex = edge.getTarget();
                reverseGraph.addEdge(targetVertex, sourceVertex);
            }
        }
        return reverseGraph;
    }

}
