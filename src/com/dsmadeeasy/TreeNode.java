package com.dsmadeeasy;


/**
 * Created by sunilpatil on 10/13/16.
 */
public class TreeNode {
    TreeNode left;
    TreeNode right;
    Integer data;
    Integer value;

    TreeNode() {

    }

    TreeNode(Integer data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                ", value=" + value +
                '}';
    }
}
