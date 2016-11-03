package com.algo4.chapter4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by sunilpatil on 10/26/16.
 */
public class SymbolGraph {
    Graph G;
    private ST<String, Integer> st;
    private String[] keys;

    public SymbolGraph(String fileName, String delim) {
        st = new ST<>();
        In in = new In(fileName);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delim);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }
        keys = new String[st.size()];
        for (String name : st)
            keys[st.get(name)] = name;

        G = new Graph(st.size());
        in = new In(fileName);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delim);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++)
                G.addEdge(v, st.get(a[i]));
        }


    }

    public static void main(String[] argv) {
        String fileName = argv[0];
        String delim = argv[1];

        SymbolGraph symbolGraph = new SymbolGraph(fileName, delim);

        Graph G = symbolGraph.G();

        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            for (int w : G.adj(symbolGraph.index(source))) {
                StdOut.print("  " + symbolGraph.name(w));
            }
        }
    }

    public boolean contains(String key) {
        return st.contains(key);
    }

    public int index(String key) {
        return st.get(key);
    }

    public String name(int v) {
        return keys[v];
    }

    Graph G() {
        return G;
    }

}
