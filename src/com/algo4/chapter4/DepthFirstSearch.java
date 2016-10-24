package com.algo4.chapter4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by sunilpatil on 10/24/16.
 */
public class DepthFirstSearch {
    boolean[] marked;
    int count;

    public DepthFirstSearch(Graph G, int S) {
        marked = new boolean[G.V()];
        dfs(G, S);
    }

    public static void main(String[] argv) {
        Graph G = new Graph(new In(argv[0]));
        int s = Integer.parseInt(argv[1]);
        DepthFirstSearch search = new DepthFirstSearch(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                StdOut.print(v + " ");
        }
        StdOut.print();

        if (search.count() != G.V())
            StdOut.println("NOT ");
        StdOut.println("connected");
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v))
            if (!marked(w))
                dfs(G, w);
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
