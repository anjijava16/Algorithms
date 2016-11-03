package com.algo4.chapter4;

import edu.princeton.cs.algs4.In;

/**
 * Created by sunilpatil on 10/26/16.
 */
public class TwoColors {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColors(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s])
                dfs(G, s);
        }
    }

    public static void main(String[] argv) {
        Graph G = new Graph(new In(argv[0]));
        TwoColors twoColors = new TwoColors(G);
        System.out.println("Two Colors " + twoColors.isBipartite());
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            } else if (color[w] == color[v])
                isTwoColorable = false;
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }
}
