package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Tree;
import com.naocn.leoj.spring.core.demo.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigExample {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Tree tree = context.getBean("tree", Tree.class);
        tree.sayHello();
    }
}
