package com.algo4.chapter3;

/**
 * Created by sunilpatil on 10/5/16.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private boolean isRed(Node x) {
        if (x == null)
            return false;

        return x.color == RED;
    }

    private Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x.value;
        }
        return null;
    }

    private Node rotateLeft(Node h) {
        assert isRed(h);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        assert isRed(h.right);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;

    }

    private void flipColors(Node h) {
        assert !isRed(h);
        assert isRed(h.right);
        assert isRed(h.left);

        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null)
            return new Node(key, value, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0)
            h.left = put(h.left, key, value);
        else if (cmp > 0)
            h.right = put(h.right, key, value);
        else
            h.value = value;

        if (isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))
            flipColors(h);

        return h;
    }

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private boolean color;

        Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }
}
