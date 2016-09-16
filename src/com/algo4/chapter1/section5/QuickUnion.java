package com.algo4.chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by sunilpatil on 9/10/16.
 */
public class QuickUnion {
    int[] id;

    public QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
         id[pRoot] = qRoot;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int p) {
        int root = p;
        while (id[root] != root) {
            root = id[root];
        }
        return root;
    }
/*
    public static void main(String[] argv) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
    }
    */

    public static void main(String[] argv){
        QuickUnion quickUnion = new QuickUnion(10);
        System.out.println(Arrays.toString(quickUnion.id));
        quickUnion.union(4,3);
        System.out.println(Arrays.toString(quickUnion.id));
        quickUnion.union(3,8);
        System.out.println(Arrays.toString(quickUnion.id));
        quickUnion.union(6,5);
        System.out.println(Arrays.toString(quickUnion.id));
        quickUnion.union(9,4);
        System.out.println(Arrays.toString(quickUnion.id));
        quickUnion.union(2,1);
        System.out.println(Arrays.toString(quickUnion.id));

        System.out.println("connected(8,9) " + quickUnion.connected(8,9));
        System.out.println("connected(2,8) " + quickUnion.connected(2,8));
        quickUnion.union(5,0);
        System.out.println(Arrays.toString(quickUnion.id));
        quickUnion.union(7,2);
        System.out.println(Arrays.toString(quickUnion.id));
        quickUnion.union(6,1);
        System.out.println(Arrays.toString(quickUnion.id));
        quickUnion.union(7,3);
        System.out.println(Arrays.toString(quickUnion.id));
    }
}
