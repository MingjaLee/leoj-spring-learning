package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycleExample2 {
    static class Tree3 {
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

    static class LifeCycleConfig2 {
        @Bean
        public Leaf leaf() {
            Leaf leaf = new Leaf();
            leaf.setName("green");
            return leaf;
        }

        @Bean
        public Tree3 tree3() {
            return new Tree3();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("context about to start.");
        GenericApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig2.class);
        context.registerShutdownHook();
        System.out.println("context ready.");
        Tree3 tree3 = context.getBean("tree3", Tree3.class);
        tree3.sayHello();
        Thread.sleep(500);
        context.close();
    }
}
