package com.coursera.ada1.week6;

/**
 * Created by sunilpatil on 12/5/16.
 */
public interface HashMap<Key, Value> {

    public void insert(Key key, Value value);

    public void delete(Key key);

    public Value get(Key key);


}
