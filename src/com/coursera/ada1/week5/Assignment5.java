package com.coursera.ada1.week5;

import com.coursera.ada1.week4.AdjListDirectedGraph;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by sunilpatil on 12/1/16.
 */
public class Assignment5 {

    public static void main(String[] argv) throws Exception {
        Assignment5 assignment5 = new Assignment5();
        AdjListDirectedGraph graph = assignment5.readArray(argv[0]);
        //  System.out.println("After parsing graph");
        //   graph.printGraph();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        dijkstraShortestPath.calculateShortedPath("1");
        //7,37,59,82,99,115,133,165,188,197
        System.out.print(dijkstraShortestPath.getShortestDistance("7"));
        System.out.print("," + dijkstraShortestPath.getShortestDistance("37"));
        System.out.print("," + dijkstraShortestPath.getShortestDistance("59"));
        System.out.print("," + dijkstraShortestPath.getShortestDistance("82"));
        System.out.print("," + dijkstraShortestPath.getShortestDistance("99"));
        System.out.print("," + dijkstraShortestPath.getShortestDistance("115"));
        System.out.print("," + dijkstraShortestPath.getShortestDistance("133"));
        System.out.print("," + dijkstraShortestPath.getShortestDistance("165"));
        System.out.print("," + dijkstraShortestPath.getShortestDistance("188"));
        System.out.print("," + dijkstraShortestPath.getShortestDistance("197"));

    }

    private AdjListDirectedGraph readArray(String filePath) throws Exception {

        AdjListDirectedGraph adjancyListGraph = new AdjListDirectedGraph();


        for (int i = 0; i <= 200; i++) {
            //        System.out.println("Adding vertex " + i);
            adjancyListGraph.addVertex(Integer.toString(i));
        }
        ArrayList<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(line, "\t");
            String source = st.nextToken();
            while (st.hasMoreTokens()) {
                String targetStr = st.nextToken();

                StringTokenizer targetTk = new StringTokenizer(targetStr, ",");
                String target = targetTk.nextToken();
                int edgeLength = Integer.parseInt(targetTk.nextToken());
                adjancyListGraph.addEdge(source, target, edgeLength);
            }
        }

        return adjancyListGraph;
    }
}
