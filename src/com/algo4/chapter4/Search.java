package com.algo4.chapter4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by sunilpatil on 10/24/16.
 */
public class Search {
    Search(Graph G, int s) {

    }

    public static void main(String[] argv) {
        Graph G = new Graph(new In(argv[0]));
        int s = Integer.parseInt(argv[1]);
        Search search = new Search(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                StdOut.print(v + " ");
        }
        StdOut.print();

        if (search.count() != G.V())
            StdOut.println("NOT ");
        StdOut.println("connected");
    }

    boolean marked(int v) {
        return false;
    }

    public int count() {
        return 0;
    }
}
