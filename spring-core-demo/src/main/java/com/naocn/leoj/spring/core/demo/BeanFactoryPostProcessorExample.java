package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import com.naocn.leoj.spring.core.demo.processor.MyBeanFactoryPostProcessor;
import com.naocn.leoj.spring.core.demo.processor.MyBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanFactoryPostProcessorExample {
    @Configuration
    static class Config {
        @Bean
        public Leaf leaf() {
            Leaf leaf = new Leaf();
            leaf.setName("green");
            return leaf;
        }

        @Bean
        public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
            return new MyBeanFactoryPostProcessor();
        }

        @Bean
        public MyBeanPostProcessor myBeanPostProcessor() {
            return new MyBeanPostProcessor();
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        System.out.println("....register Config....");
        context.register(Config.class);
        context.refresh();
        Leaf leaf = context.getBean("leaf", Leaf.class);
        leaf.sayHello();
        context.close();
    }
}
