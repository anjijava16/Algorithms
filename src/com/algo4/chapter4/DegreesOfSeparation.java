package com.algo4.chapter4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by sunilpatil on 10/26/16.
 */
public class DegreesOfSeparation {
    public static void main(String[] argv) {
        SymbolGraph sg = new SymbolGraph(argv[0], argv[1]);

        Graph G = sg.G();
        String source = argv[2];
        if (!sg.contains(source)) {
            StdOut.println(source + " not in database");
            return;
        }

        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if (sg.contains(sink)) {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t))
                    for (int v : bfs.pathTo(t))
                        StdOut.println(" " + sg.name(v));
                else
                    StdOut.println("Not Connected");
            } else {
                StdOut.println("Not in database.");
            }
        }
    }
}
