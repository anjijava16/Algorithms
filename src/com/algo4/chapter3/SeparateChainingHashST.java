package com.algo4.chapter3;

/**
 * Created by sunilpatil on 10/10/16.
 */
public class SeparateChainingHashST<Key, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st = null;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    }

    public static void main(String[] argv) {
        SeparateChainingHashST<String, String> linearProbingHashST = new SeparateChainingHashST<>();
        linearProbingHashST.put("first", "one");
        linearProbingHashST.put("second", "two");
        linearProbingHashST.put("third", "three");
        linearProbingHashST.put("fourth", "four");

        System.out.println(linearProbingHashST.get("first"));
        System.out.println(linearProbingHashST.get("fifth"));
    }

    private int hash(Key key) {
        return (key.hashCode() & 0xfffffff) % M;
    }

    public Value get(Key key) {
        SequentialSearchST keyValueSequentialSearchST = this.st[hash(key)];
        return (Value) keyValueSequentialSearchST.get(key);
    }

    public void put(Key key, Value value) {
        SequentialSearchST keyValueSequentialSearchST = this.st[hash(key)];
        keyValueSequentialSearchST.put(key, value);
    }

    public boolean contains(Key key) {
        return get(key) == null;
    }

    public void delete(Key key) {
        if (!contains(key))
            return;
        SequentialSearchST keyValueSequentialSearchST = this.st[hash(key)];
        keyValueSequentialSearchST.delete(key);
    }
}
