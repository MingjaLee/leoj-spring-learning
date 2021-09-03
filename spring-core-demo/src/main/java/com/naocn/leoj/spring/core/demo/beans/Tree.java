package com.naocn.leoj.spring.core.demo.beans;

public class Tree {
    private Leaf leaf;

    public void sayHello() {
        System.out.println("get a leaf: " + leaf.getName());
    }
    public Tree() {
        System.out.println("construct the tree.");
    }

    public Leaf getLeaf() {
        return leaf;
    }

    public void setLeaf(Leaf leaf) {
        this.leaf = leaf;
    }
}
