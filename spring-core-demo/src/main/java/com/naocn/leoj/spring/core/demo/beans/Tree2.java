package com.naocn.leoj.spring.core.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Tree2 {
    @Autowired
    private Leaf leaf;

    public void sayHello() {
        System.out.println("get a leaf: " + leaf.getName());
    }

    public Tree2() {
        System.out.println("construct the tree.");
    }

    public void init() {
        System.out.println("init the tree.");
    }

    public void destroy() {
        System.out.println("destroy the tree.");
    }
}
