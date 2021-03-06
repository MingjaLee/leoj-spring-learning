package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import com.naocn.leoj.spring.core.demo.event.CustomApplicationEvent;
import com.naocn.leoj.spring.core.demo.listener.CustomEventListener;
import com.naocn.leoj.spring.core.demo.listener.ExampleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;

public class ListenerExample {
    @Configuration
    public static class Config {
        @Bean
        public Leaf leaf() {
            Leaf leaf = new Leaf();
            leaf.setName("green");
            return leaf;
        }

        @Bean
        public ExampleListener listener() {
            return new ExampleListener();
        }

        @Bean
        public CustomEventListener customEventListener() {
            return new CustomEventListener();
        }

        @Bean
        public CustomSpringEventPublisher customSpringEventPublisher() {
            return new CustomSpringEventPublisher();
        }

        // 注解监听器
        @EventListener
        @Order(1)
        public void listenAnnotation(CustomApplicationEvent event) {
            System.out.println(">> @EventListener1: " + event.getMessage());
        }

        @EventListener
        @Order(2)
        public void listenAnnotation2(CustomApplicationEvent event) {
            System.out.println(">> @EventListener2: " + event.getMessage());
        }

    }

    public static class CustomSpringEventPublisher {

        @Autowired
        ApplicationEventPublisher applicationEventPublisher;

        public void publishCustomEvent(String message) {
            CustomApplicationEvent customSpringEvent = new CustomApplicationEvent(this, message);
            // 发布事件
            applicationEventPublisher.publishEvent(customSpringEvent);
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("==========publish event=========");
        CustomSpringEventPublisher publisher = context.getBean(CustomSpringEventPublisher.class);
        publisher.publishCustomEvent("this is event!");
    }

}
