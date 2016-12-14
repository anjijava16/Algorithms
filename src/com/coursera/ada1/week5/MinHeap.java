package com.coursera.ada1.week5;

/**
 * Created by sunilpatil on 11/29/16.
 */
public class MinHeap<Key extends Comparable<Key>> {

    Key[] a;
    int c;

    public MinHeap(Key[] array) {
        this.a = array;
        this.c = 0;
    }

    public void insert(Key n) {
        a[++c] = n;
        swim(c);
    }

    public Key peek() {
        return a[1];
    }

    public Key getMin() {
        //
        Key returnValue = a[1];
        a[1] = null;
        exch(1, c);
        sink(1);
        c = c - 1;
        return returnValue;
    }

    public void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    public void sink(int k) {
        while (2 * k < c) {
            int j = 2 * k;
            if (j + 1 < c && less(j + 1, j))
                j = j + 1;
            if (less(k, j))
                break;
            exch(j, k);
            k = j;
        }
    }

    private boolean less(int f, int s) {

        if (a[f].compareTo(a[s]) < 0)
            return true;
        else return false;
    }

    private void exch(int f, int s) {
        Key t = a[f];
        a[f] = a[s];
        a[s] = t;
    }

    public int getSize() {
        return c;
    }
}
