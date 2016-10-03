package com.algo4.chapter2;

import java.util.Arrays;

/**
 * Created by sunilpatil on 9/26/16.
 */
public class MaxPQ<Key extends Comparable<Key>> {

    Key[] pq;
    int N = 0;

    public MaxPQ(){

    }

    public MaxPQ(int max){
        pq = (Key[])new Comparable[max+1];
    }

    public MaxPQ(Key[] a){
        pq = a;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key max(){
        return pq[1];
    }

    public Key delMax(){
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    public boolean isEmpty(){
        return N ==0;
    }

    public int size(){
        return N;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) <0;
    }

    private void exch(int i, int j){
        Key t= pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k){
        while(k>1&& less(k/2,k)){
            exch(k/2,k);
            k = k/2;
        }
    }

    private void sink(int k){
        while(2*k < N){
            int j = 2*k;
            if (j <N && less(j, j+1))
                j++;
            if(!less(k,j))
                break;
            exch(j,k);
            k = j;
        }
    }

    public static void main(String[] argv){
        MaxPQ<Integer> maxPQ = new MaxPQ<>(10);
        maxPQ.insert(5);
        maxPQ.insert(6);
        maxPQ.insert(4);
        maxPQ.insert(7);
        maxPQ.insert(3);
        maxPQ.insert(8);

        System.out.println("Value of array " + Arrays.toString(maxPQ.pq));
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        maxPQ.insert(2);
        System.out.println("Value of array " + Arrays.toString(maxPQ.pq));


    }
}
