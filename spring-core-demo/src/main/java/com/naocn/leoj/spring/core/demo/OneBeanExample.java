package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OneBeanExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/one-bean.xml");
        Leaf leaf = context.getBean("leaf", Leaf.class);
        leaf.sayHello();

        // <alias> example
        Leaf leaf1 = context.getBean("leaf1", Leaf.class);
        leaf1.sayHello();
    }
}
