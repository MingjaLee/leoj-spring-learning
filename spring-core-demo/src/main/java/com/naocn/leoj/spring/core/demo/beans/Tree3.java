package com.naocn.leoj.spring.core.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Tree3 {
    @Autowired
    private Leaf leaf;

    public void sayHello() {
        System.out.println("get a leaf: " + leaf.getName());
    }

    public Tree3() {
        System.out.println("construct the tree.");
    }

    @PostConstruct
    public void init() {
        System.out.println("init the tree.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy the tree.");
    }
}
