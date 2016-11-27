package com.coursera.ada1.week4;

import java.io.File;
import java.util.*;

/**
 * Created by sunilpatil on 11/27/16.
 */
public class Assignment4 {

    public static void main(String[] argv) throws Exception {
        Assignment4 assignment4 = new Assignment4();
        System.out.println("Before starting to parse file");
        AdjListDirectedGraph graph = assignment4.readArray(argv[0]);
        System.out.println("After parsing the file");
        // graph.printGraph();
        KasaRajuSCC kasaRajuSCC = new KasaRajuSCC(graph);
        System.out.println("Before calculating leaders");
        Map<String, Integer> leadersMap = kasaRajuSCC.calculateSCC();
        System.out.println("After calculating leaders");
        System.out.println("Number of leaders " + leadersMap.values().size());
        List<Integer> countsList = new ArrayList<>();
        Iterator<Integer> leaderCountsIt = leadersMap.values().iterator();
        while (leaderCountsIt.hasNext())
            countsList.add(leaderCountsIt.next());
        Collections.sort(countsList);

        System.out.println("Printing results ");

        for (int i = countsList.size() - 5; i < countsList.size(); i++)
            System.out.print(countsList.get(i) + ",");
        //    System.out.println("Leaders Map " + countsList);
    }

    private AdjListDirectedGraph readArray(String filePath) throws Exception {

        AdjListDirectedGraph adjancyListGraph = new AdjListDirectedGraph();

        System.out.println("Before creating vertex");
        for (int i = 0; i <= 875714; i++) {
            //   if(i %1000 == 0)
            //   System.out.println("Adding vertex " + i);
            adjancyListGraph.addVertex(Integer.toString(i));
        }
        ArrayList<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        int edgeCounter = 1;
        System.out.println("Before inserting edges");
        for (String line : lines) {
            edgeCounter++;
            Scanner scanner1 = new Scanner(line);
            String source = scanner1.next();
            String target = scanner1.next();
            // if(edgeCounter %1000 == 0)
            // System.out.println("Inserting edge no. " + edgeCounter);
            adjancyListGraph.addEdge(source, target);
        }
        return adjancyListGraph;
    }
}
