package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import com.naocn.leoj.spring.core.demo.beans.Tree3;
import com.naocn.leoj.spring.core.demo.config.LifeCycleConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;

public class LifeCycleExample2 {
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
        GenericApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig2.class);
        Tree3 tree3 = context.getBean("tree3", Tree3.class);
        tree3.sayHello();
        Thread.sleep(500);
        context.close();
    }
}
