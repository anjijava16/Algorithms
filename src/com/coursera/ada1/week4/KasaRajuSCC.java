package com.coursera.ada1.week4;

import java.util.*;

/**
 * Created by sunilpatil on 11/25/16.
 */
public class KasaRajuSCC {
    AdjListDirectedGraph graph;
    HashSet<Vertex> marked;
    private int currentLabel;
    private String leader;

    public KasaRajuSCC(AdjListDirectedGraph graph) {
        this.graph = graph;
    }

    public Map<String, Integer> calculateSCC() {
        // Reverse the graph
        AdjListDirectedGraph reversedGraph = reverse(graph);

        System.out.println("Before calculateFinishingTime");
        // Calcualte Finishing time
        calculateFinishingTime(reversedGraph);

        System.out.println("Before attachFinishingTimes");
        // Attach finishing time back to original graph
        attachFinishingTimes(graph, reversedGraph);

        System.out.println("Before collections.sort");

        //Sort the graph based on finishing time
        Collections.sort(graph.getVertexList(), new TopologicalOrderComparator());

        System.out.println("Before calculateLeaders");

        //TODO: Calculate leaders
        calculateLeaders();

        //TODO: Calculate counts for each leader
        return countLeaders();
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
                reverseGraph.addEdge(targetVertex.getLabel(), sourceVertex.getLabel());
            }
        }
        return reverseGraph;
    }

    void calculateFinishingTime(AdjListDirectedGraph graph) {
        marked = new HashSet<>();
        List<Vertex> vertexList = graph.getVertexList();
        int vertexCount = vertexList.size();
        currentLabel = 1;
        for (int j = vertexCount - 1; j >= 0; j--) {
            Vertex currentVertex = vertexList.get(j);
            if (!marked.contains(currentVertex)) {
                System.out.println("Starting dfs on " + currentVertex.getLabel());
                dfs(graph, currentVertex);
            }
        }
    }

    void dfs(AdjListDirectedGraph graph, Vertex source) {
        if (marked.contains(source))
            return;
        // System.out.println("Inside dfs recursive " + source);
        marked.add(source);
        List<Edge> edgeList = source.getEdgeList();
        for (Edge edge : edgeList) {
            dfs(graph, edge.getTarget());
        }
        source.setTopologicalOrder(currentLabel++);
    }

    void attachFinishingTimes(AdjListDirectedGraph graph, AdjListDirectedGraph reversedGraph) {

        List<Vertex> vertexList = graph.getVertexList();
        for (Vertex vertex : vertexList) {
            String label = vertex.getLabel();
            int order = getFinishingTime(reversedGraph, label);
            vertex.setTopologicalOrder(order);
        }
    }

    private int getFinishingTime(AdjListDirectedGraph reversedGraph, String label) {
        List<Vertex> vertexList = reversedGraph.getVertexList();
        return reversedGraph.vertexHashMap.get(label).getTopologicalOrder();
      /*  for(Vertex v: vertexList){
            if(v.getLabel().equals(label))
                return v.getTopologicalOrder();
        }
        throw new IllegalArgumentException("Found bad label " + label);*/
    }

    void calculateLeaders() {
        marked = new HashSet<>();
        List<Vertex> vertexList = graph.getVertexList();
        for (int i = vertexList.size() - 1; i >= 0; i--) {
            Vertex currentVertex = vertexList.get(i);
            leader = currentVertex.getLabel();
            calculateLeadersDFS(graph, currentVertex);
        }
    }

    void calculateLeadersDFS(AdjListDirectedGraph graph, Vertex source) {
        if (marked.contains(source))
            return;
        marked.add(source);

        List<Edge> edgeList = source.getEdgeList();
        for (Edge edge : edgeList) {
            calculateLeadersDFS(graph, edge.getTarget());
        }
        source.setLeader(leader);
    }

    Map<String, Integer> countLeaders() {
        Map<String, Integer> leaderCountMap = new HashMap<>();
        List<Vertex> vertexList = graph.getVertexList();
        for (Vertex vertex : vertexList) {
            String leader = vertex.getLeader();
            if (leaderCountMap.get(leader) != null) {
                Integer currentCount = leaderCountMap.get(leader);
                leaderCountMap.put(leader, currentCount + 1);
            } else {
                leaderCountMap.put(leader, 1);
            }
        }
        return leaderCountMap;
    }

    public static class TopologicalOrderComparator implements Comparator<Vertex> {
        @Override
        public int compare(Vertex vertex1, Vertex vertex2) {
            return vertex1.getTopologicalOrder() - vertex2.getTopologicalOrder();
        }
    }


}
