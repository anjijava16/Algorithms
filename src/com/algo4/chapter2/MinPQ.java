package com.algo4.chapter2;

import com.algo4.chapter1.section3.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by sunilpatil on 9/28/16.
 */
public class MinPQ<Key extends Comparable<Key>> {

    public MinPQ(){

    }

    public MinPQ(int max){

    }

    public MinPQ(Key[] a){

    }

    public void insert(Key v){

    }

    public Key min(){
        return null;
    }

    public Key delMin(){
        return null;
    }

    public boolean isEmpty(){
        return false;
    }

    public int size(){
        return 0;
    }

    public static void main(String[] argv){
        int M = Integer.parseInt(argv[0]);
        MinPQ<Integer> minPQ = new MinPQ<>(M+1);

        while (StdIn.hasNextLine()){
            minPQ.insert(StdIn.readInt());
            if(minPQ.size() > M)
                minPQ.delMin();
        }

        Stack<Integer> stack = new Stack<Integer>();
        while(!minPQ.isEmpty())
            stack.push(minPQ.delMin());

        for(Integer i: stack)
            StdOut.println(i);

    }
}
