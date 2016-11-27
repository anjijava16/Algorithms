package com.coursera.ada1.week4;

import org.junit.Test;

import java.util.Map;

/**
 * Created by sunilpatil on 11/26/16.
 */
public class KasaRajuSCCTest {

    KasaRajuSCC kasaRajuSCC;

    public void setup() {

    }

    @Test
    public void testSCC() {
        AdjListDirectedGraph inputGraph = getTestGraph();
        kasaRajuSCC = new KasaRajuSCC(inputGraph);
        Map<String, Integer> sccMap = kasaRajuSCC.calculateSCC();

        System.out.println("Final graph");
        inputGraph.printGraph();

        System.out.println(sccMap);
    }

    @Test
    public void testReverseGraph() {
        AdjListDirectedGraph graph = new AdjListDirectedGraph();
        kasaRajuSCC = new KasaRajuSCC(graph);

        Vertex one = graph.addVertex("1");
        Vertex two = graph.addVertex("2");
        Vertex three = graph.addVertex("3");
        Vertex four = graph.addVertex("4");
        Vertex five = graph.addVertex("5");
        Vertex six = graph.addVertex("6");
        Vertex seven = graph.addVertex("7");
        Vertex eight = graph.addVertex("8");
        Vertex nine = graph.addVertex("9");

        graph.addEdge(one, seven);
        graph.addEdge(seven, four);
        graph.addEdge(four, one);

        graph.addEdge(seven, nine);
        graph.addEdge(nine, six);
        graph.addEdge(six, three);
        graph.addEdge(three, nine);

        graph.addEdge(six, eight);
        graph.addEdge(eight, two);
        graph.addEdge(two, five);
        graph.addEdge(five, eight);


        graph.printGraph();

        System.out.println("Reversed Graph");
        AdjListDirectedGraph reverseGraph = kasaRajuSCC.reverse(graph);
        reverseGraph.printGraph();

    }

    @Test
    public void testCalculateFinishingTimeOnReversedGraph() {
        AdjListDirectedGraph graph = new AdjListDirectedGraph();
        kasaRajuSCC = new KasaRajuSCC(graph);

        Vertex one = graph.addVertex("1");
        Vertex two = graph.addVertex("2");
        Vertex three = graph.addVertex("3");
        Vertex four = graph.addVertex("4");
        Vertex five = graph.addVertex("5");
        Vertex six = graph.addVertex("6");
        Vertex seven = graph.addVertex("7");
        Vertex eight = graph.addVertex("8");
        Vertex nine = graph.addVertex("9");

        graph.addEdge(one, seven);
        graph.addEdge(seven, four);
        graph.addEdge(four, one);

        graph.addEdge(seven, nine);
        graph.addEdge(nine, six);
        graph.addEdge(six, three);
        graph.addEdge(three, nine);

        graph.addEdge(six, eight);
        graph.addEdge(eight, two);
        graph.addEdge(two, five);
        graph.addEdge(five, eight);
        graph.printGraph();


        // TopologicalSort sort = new TopologicalSort(reverseGraph);
        // sort.sort();
        kasaRajuSCC.calculateFinishingTime(graph);
        System.out.println("Finishing time ");
        graph.printGraph();
    }

    @Test
    public void calculateFinishingTime() {
        AdjListDirectedGraph graph = getTestGraph();
        kasaRajuSCC = new KasaRajuSCC(graph);
        AdjListDirectedGraph reversedGraph = kasaRajuSCC.reverse(graph);
        System.out.println("Print reversed Graph");
        reversedGraph.printGraph();

        kasaRajuSCC.calculateFinishingTime(reversedGraph);
        System.out.println("Print finished time ");
        reversedGraph.printGraph();
    }

    private AdjListDirectedGraph getTestGraph() {
        AdjListDirectedGraph graph = new AdjListDirectedGraph();
        Vertex one = graph.addVertex("1");
        Vertex two = graph.addVertex("2");
        Vertex three = graph.addVertex("3");
        Vertex four = graph.addVertex("4");
        Vertex five = graph.addVertex("5");
        Vertex six = graph.addVertex("6");
        Vertex seven = graph.addVertex("7");
        Vertex eight = graph.addVertex("8");
        Vertex nine = graph.addVertex("9");
        graph.addEdge(seven, one);
        graph.addEdge(one, four);
        graph.addEdge(four, seven);
        graph.addEdge(nine, seven);
        graph.addEdge(nine, three);
        graph.addEdge(three, six);
        graph.addEdge(six, nine);
        graph.addEdge(eight, six);
        graph.addEdge(two, eight);
        graph.addEdge(five, two);
        graph.addEdge(eight, five);

        System.out.println("Print Graph");
        graph.printGraph();

        return graph;
    }
}
