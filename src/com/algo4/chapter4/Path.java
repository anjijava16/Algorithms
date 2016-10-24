package com.algo4.chapter4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by spatil30 on 10/24/2016.
 */
public class Path {
    public Path(Graph G, int s){

    }

    public boolean hasPathTo(int v){
        return false;
    }

    public Iterable<Integer> pathTo(int v){
        return null;
    }

    public static void main(String[] args){
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        Path search = new Path(G,s);

        for(int v = 0; v < G.V(); v++){
            if(search.hasPathTo(v)){
                for(int x : search.pathTo(v))
                    if(x == s )
                        StdOut.print(x);
                    else
                        StdOut.print("_" + x);
                StdOut.println();
            }
        }
    }
}
