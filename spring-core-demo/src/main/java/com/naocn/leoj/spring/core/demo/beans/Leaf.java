package com.naocn.leoj.spring.core.demo.beans;

public class Leaf {
    private String name;

    public Leaf() {
        System.out.println("construct Leaf");
    }

    public void sayHello() {
        System.out.println(this.name + " say Hello to you.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
