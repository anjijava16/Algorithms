package com.algo4.chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by sunilpatil on 9/9/16.
 */
public class UF {

    int[] a;
    public UF(int N){
        a = new int[N];
        for(int i =0 ; i < N; i++)
            a[i] = i;
    }

    public void union(int p, int q){
        int firstValue = a[p];
        int secondValue = a[q];
        for(int i =0 ; i < a.length; i++){
            if(a[i] == secondValue){
                a[i] = firstValue;
            }
        }
    }

    public boolean connected(int p, int q){
        if(a[p] == a[q])
            return true;
        return false;
    }

    public int find(int p){
        return 0;
    }

    public int count(){
        return 0;
    }

    public static void main(String[] argv){
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(! uf.connected(p,q)){
                uf.union(p,q);
                StdOut.println(p +" " +q);
            }
        }
    }
}
