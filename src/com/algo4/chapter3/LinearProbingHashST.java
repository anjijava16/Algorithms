package com.algo4.chapter3;

/**
 * Created by sunilpatil on 10/10/16.
 */
public class LinearProbingHashST<Key, Value> {
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST() {
        this(16);
    }

    public LinearProbingHashST(int size) {
        this.M = size;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    public static void main(String[] argv) {
        LinearProbingHashST<String, String> linearProbingHashST = new LinearProbingHashST<>();
        linearProbingHashST.put("first", "one");
        linearProbingHashST.put("second", "two");
        linearProbingHashST.put("third", "three");
        linearProbingHashST.put("fourth", "four");

        System.out.println(linearProbingHashST.get("first"));
        System.out.println(linearProbingHashST.get("fifth"));
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int size) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<Key, Value>(size);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null)
                t.put(keys[i], values[i]);
        }
        keys = t.keys;
        values = t.values;
        M = t.M;
    }

    public void put(Key key, Value value) {
        if (N >= M / 2)
            resize(2 * M);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return values[i];
        return null;
    }

    public boolean contains(Key key) {
        return get(key) == null;
    }

    public void delete(Key key) {
        if (!contains(key))
            return;

        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRedo, valueToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8)
            resize(M / 2);
    }
}
