package com.algo4.chapter3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by sunilpatil on 10/3/16.
 */
public class ST<Key,Value> {
    public ST(){

    }

    public void put(Key key, Value value){

    }

    public Value get(Key key){
        return null;
    }

    public void delete(Key key){
        put(key,null);
    }

    public boolean contains(Key key){
        return get(key) == null;
    }

    public boolean isEmpty(){
        return size() ==0;
    }

    public int size(){
        return 0;
    }

    public Iterable<Key> keys(){
        return null;
    }

    public static void main(String[] argv){
        ST<String, Integer> st;
        st = new ST<String,Integer>();
        for(int i = 0; !StdIn.isEmpty();i++){
            String key = StdIn.readString();
            st.put(key,i);
        }

        for(String s: st.keys()){
            StdOut.println(s + " " + st.get(s));
        }
    }
}
