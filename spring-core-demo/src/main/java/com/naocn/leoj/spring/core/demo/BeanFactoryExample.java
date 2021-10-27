package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Tree;
import com.naocn.leoj.spring.core.demo.beans.Tree3;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryExample {
    public static void main(String[] args) {
        //test static factory method
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/bean-static-factory-sample.xml");
        Tree tree = context.getBean("tree", Tree.class);
        tree.sayHello();
        context.close();

        //test instance factory method
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("spring/bean-instance-factory-sample.xml");
        Tree3 tree3 = context1.getBean("tree", Tree3.class);
        tree3.sayHello();
        context.close();
    }
}
