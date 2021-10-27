package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Tree;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TowBeanExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/tow-bean.xml");
        Tree tree = context.getBean("tree", Tree.class);
        tree.sayHello();
    }
}
