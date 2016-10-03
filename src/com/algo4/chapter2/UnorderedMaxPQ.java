package com.algo4.chapter2;

/**
 * Created by sunilpatil on 10/1/16.
 */
public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;

    private int size =0;
    public UnorderedMaxPQ(int capacity){
        pq = (Key[]) new Comparable[capacity];
    }

    public int size(){
        return size;
    }

    public void insert(Key key){
        pq[size++] = key;
    }

    public Key delMax(){
        int max = 0;
        for(int i = 1; i < size ;i++){
            if(less(max,i))
                max = i;
        }
        Key returnKey = pq[max];
        exch(max,size-1);
        return pq[--size];
    }
    private void exch(int i, int j){
        Key t= pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) <0;
    }

    public static void main(String[] argv){
        UnorderedMaxPQ<Integer> unorderedMaxPQ = new UnorderedMaxPQ<>(5);
        unorderedMaxPQ.insert(5);
        unorderedMaxPQ.insert(7);
        unorderedMaxPQ.insert(3);
        unorderedMaxPQ.insert(9);

        System.out.println(unorderedMaxPQ.delMax());
        System.out.println(unorderedMaxPQ.delMax());
        System.out.println(unorderedMaxPQ.delMax());
        System.out.println(unorderedMaxPQ.delMax());
    }
}
