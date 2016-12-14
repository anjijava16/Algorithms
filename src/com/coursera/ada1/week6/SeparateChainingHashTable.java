package com.coursera.ada1.week6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilpatil on 12/5/16.
 */
public class SeparateChainingHashTable<Key, Value> implements HashMap {
    private static final int initialCapacity = 10;
    List[] mapList = null;

    public SeparateChainingHashTable() {
        this(initialCapacity);
    }

    public SeparateChainingHashTable(int initialCapacity) {
        mapList = new ArrayList[initialCapacity];
        for (int i = 0; i < initialCapacity; i++)
            mapList[i] = new ArrayList();
    }

    @Override
    public void insert(Object o, Object o2) {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public Object get(Object o) {
        return null;
    }
}
