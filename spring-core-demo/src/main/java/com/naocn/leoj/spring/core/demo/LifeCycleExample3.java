package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.config.Config;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycleExample3 {
    static class Tree4 implements InitializingBean, DisposableBean {
        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println(">> tree4.afterPropertiesSet");
        }

        public void sayHello() {
            System.out.println(">> tree.say Hello");
        }

        @PostConstruct
        public void init() {
            System.out.println(">> tree4.init");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println(">> tree4.DisposableBean.destroy");
        }

        @PreDestroy
        public void preDestroy() {
            System.out.println(">> tree4.preDestroy");
        }
    }

    static class Config3 {
        @Bean
        public Tree4 tree4() {
            return new Tree4();
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(Config3.class);
        Tree4 tree4 = context.getBean(Tree4.class);
        tree4.sayHello();
        context.close();
    }
}
/**
 * 优先级：注解>接口实现
 >> tree4.init
 >> tree4.afterPropertiesSet
 >> tree.say Hello
 >> tree4.preDestroy
 >> tree4.DisposableBean.destroy
 **/