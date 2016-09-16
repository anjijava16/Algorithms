package com.algo4.chapter1.section5;

import java.util.Arrays;

/**
 * Created by sunilpatil on 9/10/16.
 */
public class WeightedQuickUnion {
    int[] id;
    int[] size;

    public WeightedQuickUnion(int N){
        id = new int[N];
        size = new int[N];
        for(int i =0 ; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }

    }

    public void union(int first, int second){
        int firstRoot = findRoot(first);
        int secondRoot = findRoot(second);
        if(firstRoot == secondRoot)
            return;

        if(size[firstRoot] < size[secondRoot]){
            id[firstRoot] = secondRoot;
            size[secondRoot] += size[firstRoot];
        }else{
            id[secondRoot] = firstRoot;
            size[firstRoot] += size[secondRoot];
        }

    }

    public boolean connected(int p, int q){
        if(id[p] == id[q])
            return true;
        return false;
    }

    private int findRoot(int p) {
        int root = p;
        while (id[root] != root) {
            root = id[root];
        }
        return root;
    }

    public static void main(String[] argv){
        WeightedQuickUnion quickUnion = new WeightedQuickUnion(10);
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
