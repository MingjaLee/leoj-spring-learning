package com.naocn.leoj.spring.core.demo.extensionpoints;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExtensionPointsExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/beanpostprocessor.xml");
        Leaf leaf = context.getBean(Leaf.class);
        leaf.sayHello();

    }
}
