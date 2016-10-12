package com.algo4.chapter3;

/**
 * Created by sunilpatil on 10/3/16.
 */
public class SequentialSearchST<Key, Value> {
    private Node first;

    public static void main(String[] argv) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        System.out.println(st.get("first"));
        st.put("first", 1);
        st.put("second", 2);
        st.put("third", 3);
        System.out.println(st.get("first"));
        System.out.println(st.get("third"));

    }

    public Value get(Key key){
        if(first == null)
            return null;
        for(Node x = first; x != null ; x = x.next){
            if(key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void delete(Key key) {
        //TODO implement delete method
    }

    public void put(Key key, Value value){
        if(first == null)
            first = new Node(key,value,null);
        for(Node x = first; x != null ; x = x.next){
            if(key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key,value, first);
    }

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
