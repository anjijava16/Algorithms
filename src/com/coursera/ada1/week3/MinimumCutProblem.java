package com.coursera.ada1.week3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by sunilpatil on 11/19/16.
 */
public class MinimumCutProblem {

    public static void main(String[] argv) throws Exception {
        MinimumCutProblem minimumCutProblem = new MinimumCutProblem();
        AdjancyListGraph adjancyListGraph = minimumCutProblem.readArray(argv[0]);
        System.out.println(adjancyListGraph);
        System.out.println(minimumCutProblem.calculateMinCut(adjancyListGraph));

    }


    public int calculateMinCut(AdjancyListGraph inputGraph) {
        System.out.println("Input Graph " + inputGraph);
        if (inputGraph.getNumberOfVertices() == 2) {
            System.out.println("Minimum cut Edge list " + inputGraph.edgeList);
            return inputGraph.edgeList.size();
        }


        AdjancyListGraph outputGraph = new AdjancyListGraph(inputGraph.vertexCount);
        Random random = new Random();
        Edge removeEdge = inputGraph.edgeList.get(random.nextInt(inputGraph.edgeList.size() - 1));
        int removeEdgeSource = removeEdge.source;
        int removeEdgeTarget = removeEdge.target;
        System.out.println("Remove Edge " + removeEdge);
        for (int i = 1; i < inputGraph.vertices.length; i++) {
            int sourceVertice = i;
            List<Integer> targetVertices = inputGraph.vertices[i];
            if (i == removeEdge.target) {
                sourceVertice = removeEdge.source;
            }
            for (Integer target : targetVertices) {
                int edgeDesitnation = target;
                if (target == removeEdgeTarget) {
                    edgeDesitnation = removeEdgeSource;
                }
                outputGraph.addEdge(sourceVertice, edgeDesitnation);
            }
        }
        return calculateMinCut(outputGraph);
    }

    private AdjancyListGraph readArray(String filePath) throws Exception {
        ArrayList<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextLine()) {
            ;
            lines.add(scanner.nextLine());
        }
        AdjancyListGraph adjancyListGraph = new AdjancyListGraph(lines.size());
        for (String line : lines) {
            Scanner scanner1 = new Scanner(line);
            int v = scanner1.nextInt();
            while (scanner1.hasNextInt()) {
                adjancyListGraph.addEdge(v, scanner1.nextInt());
            }
        }
        return adjancyListGraph;
    }
}
