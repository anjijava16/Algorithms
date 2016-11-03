package com.algo4.chapter4;

import edu.princeton.cs.algs4.In;

/**
 * Created by sunilpatil on 10/25/16.
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    private Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s])
                dfs(G, s, s);
        }

    }

    public static void main(String[] argv) {
        Graph G = new Graph(new In(argv[0]));
        Cycle cycle = new Cycle(G);
        System.out.println("cycle.hasCycle " + cycle.hasCycle());
    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w])
                dfs(G, w, v);
            else if (w != u)
                hasCycle = true;
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
