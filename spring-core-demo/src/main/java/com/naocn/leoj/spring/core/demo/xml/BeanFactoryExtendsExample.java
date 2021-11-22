package com.naocn.leoj.spring.core.demo.xml;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * BeanFactory 接口扩展功能案例，如AutowireCapableBeanFactory
 */
public class BeanFactoryExtendsExample {

    @Configuration
    static class Config {
        @Bean
        public Leaf leaf() {
            Leaf leaf = new Leaf();
            leaf.setName("blue");
            return leaf;
        }
    }

    static class Tree {
        public Tree() {
            System.out.println("construct tree");
        }

        @Autowired
        private Leaf leaf;

        public void sayHello() {
            System.out.println(">> tree get a leaf: " + leaf.getName());
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AutowireCapableBeanFactory beanFactory = context.getBeanFactory();
        Tree tree = beanFactory.createBean(Tree.class);
        tree.sayHello();

        try {
            context.getBean(Tree.class);
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("context not contain Tree Bean.");
        }
    }
}
