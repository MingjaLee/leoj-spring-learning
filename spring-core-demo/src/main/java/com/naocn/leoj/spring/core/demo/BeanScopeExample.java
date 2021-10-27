package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.GenericApplicationContext;

public class BeanScopeExample {
    static class Tree {
        @Autowired
        private Leaf leaf;

        public void sayHello() {
            System.out.println("tree get a leaf: " + leaf.getName());
        }
    }

    @Configuration
    static class ScopeConfig {
        @Bean
        public Leaf leaf() {
            Leaf leaf = new Leaf();
            leaf.setName("green");
            return leaf;
        }

        @Bean
        @Scope("prototype")
        public Tree tree() {
            return new Tree();
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        Leaf leaf1 = context.getBean(Leaf.class);
        Leaf leaf2 = context.getBean(Leaf.class);
        System.out.println("leaf1 is equal leaf2: " + leaf1.equals(leaf2));

        Tree tree1 = context.getBean(Tree.class);
        Tree tree2 = context.getBean(Tree.class);
        System.out.println("tree1 is equal tree2: " + tree1.equals(tree2));

    }
}
