package com.naocn.leoj.spring.core.demo.beans;

public class Tree3 {
    private Leaf leaf;

    public Tree3(Leaf leaf) {
        this.leaf = leaf;
    }

    public Leaf getLeaf() {
        return leaf;
    }

    public void setLeaf(Leaf leaf) {
        this.leaf = leaf;
    }

    public void sayHello() {
        System.out.println("tree3 get a leaf: " + leaf.getName());
    }
}
