package com.algo4.chapter3;


import edu.princeton.cs.algs4.Queue;

/**
 * Created by sunilpatil on 10/3/16.
 */
public class BST<Key extends Comparable<Key>, Value>  {

    private Node root;

    public static void main(String[] argv) {
        BST<String, Integer> st = new BST<>();
        st.put("first", 1);

        st.put("second", 2);

        st.put("third", 3);
        st.put("fourth", 4);
        st.put("fifth", 5);
        st.put("sixth", 6);
        st.put("seventh", 7);
        st.put("eigth", 8);
        st.put("ninth", 9);
        st.put("tenth", 10);

        for (String s : st.keys())
            System.out.println(s + " " + st.get(s));

    }

    public void put(Key key, Value value){
        root = put(root, key,value);
    }

    private Node put(Node x, Key key, Value value){
        if(x == null)
            return new Node(key, value,1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = put(x.left,key,value);
        else if (cmp > 0)
            x.right =put(x.right,key,value);
        else if(cmp == 0)
            x.value = value;

        x.count = 1+ size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key key){
        Node x = root;
        while(x != null){
            int cmp = key.compareTo(x.key);
            if(cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else if(cmp == 0)
                return x.value;
        }
        return null;
    }

    public Key min(){
        Node x = root;
        while(x.left != null){
            x = x.left;
        }
        return x.key;
    }


    public Key max(){
        Node y = root;
        while(y.right != null){
            y = y.right;
        }
        return y.key;
    }

    public Key max(Node y) {
        while (y.right != null) {
            y = y.right;
        }
        return y.key;
    }

    public Key floor(Key key){
        Node x = floor(root, key);
        if(x == null)
            return null;
        return x.key;
    }

    private Node floor(Node x, Key key){
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return x;
        if(cmp < 0)
            return floor(x.left,key);

        Node t = floor(x.right,key);
        if(t!= null)
            return t;
        else
            return x;
    }

    public Key ceiling(Key key){
        Node x = ceiling(root, key);
        if(x == null)
            return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key){
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return x;

        if(cmp > 0)
            return ceiling(x.right,key);

        Node t = ceiling(x.left,key );
        if(t!= null)
            return t;
        else
        return x;
    }

    public int size(){
        return size(root);
    }

    public int size(Node x){
        if(x == null)
            return 0;
        else
            return x.count;
    }

    public int rank(Key key){
        return rank(key, root);
    }

    public Iterable<Key> keys(){
        Queue<Key> q = new Queue<Key>();
        inorder(root,q);
        return q;
    }

    public void inorder(Node x, Queue<Key> q){
        if(x == null)
            return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right,q);
    }

    private int rank(Key key, Node x){
        if(x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return rank(key, x.left);
        else if(cmp >0)
            return 1+ size(x.left) + rank(key, x.right);
        else
            return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(x.right);
            x.left = t.left;
        }
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    Node min(Node x) {
        while (x.left != null)
            x = x.left;
        return x;
    }

    public Iterable<Key> iterator() {
        return null;
    }

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int count;

        public Node(Key key, Value value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    ", count=" + count +
                    '}';
        }
    }
}
