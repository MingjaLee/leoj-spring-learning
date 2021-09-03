package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Tree2;
import com.naocn.leoj.spring.core.demo.config.DIConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SuppressWarnings("resource")
public class DIExample {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);
        Tree2 tree2 = context.getBean("tree2", Tree2.class);
        tree2.sayHello();
    }
}
