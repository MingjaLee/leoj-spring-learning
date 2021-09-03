package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Tree2;
import com.naocn.leoj.spring.core.demo.config.LifeCycleConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class LifeCycleExample {
    public static void main(String[] args) throws InterruptedException {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        Tree2 tree2 = context.getBean("tree2", Tree2.class);
        tree2.sayHello();
        Thread.sleep(500);
        context.close();
    }
}
