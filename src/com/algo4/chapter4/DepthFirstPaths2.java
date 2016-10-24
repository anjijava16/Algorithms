package com.algo4.chapter4;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * Created by spatil30 on 10/24/2016.

public class DepthFirstPaths2 {
    private boolean[] marked;
    private Stack<PathElement> pathElementStack;
    private final int s;

    public DepthFirstPaths2(Graph G, int s){
        marked = new boolean[G.V()];
        pathElementStack = new Stack<>();
        this.s = s;
        dfs(G,s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for(int w: G.adj(v)){
            if(!marked[w]){
                pathElementStack.push(new PathElement(v,w));
                dfs(G,w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<PathElement> pathTo(int v){
        if(!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int x= v; x!=s ; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args){
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths2 search = new DepthFirstPaths2(G,s);

        for(int v = 0; v < G.V(); v++){
            StdOut.print(v +" -> ");
            if(search.hasPathTo(v)){
                for(int x : search.pathTo(v))
                    if(x == s )
                        StdOut.print("_"+x);
                    else
                        StdOut.print("_" + x);
                StdOut.println();
            }
        }
    }

    private class PathElement{
        private int start;
        private int end;

        public PathElement(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "PathElement{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
 */