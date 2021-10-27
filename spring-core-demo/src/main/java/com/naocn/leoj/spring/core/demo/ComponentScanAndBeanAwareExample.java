package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import com.naocn.leoj.spring.core.demo.component.ExampleAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// bean does not aware ioc container but bean can aware spring
public class ComponentScanAndBeanAwareExample {
    @Configuration
    @ComponentScan("com.naocn.leoj.spring.core.demo.component")
    static class Config {
        @Bean
        public Leaf leaf() {
            Leaf leaf = new Leaf();
            leaf.setName("green");
            return leaf;
        }
    }

//    @SuppressWarnings({"resources", "static-access"})
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ExampleAware exampleAware = context.getBean(ExampleAware.class);
        // get bean name from spring
        exampleAware.getBeanName();

        // get bean from spring, so bean can get another bean from spring
        exampleAware.getBean(Leaf.class).sayHello();
    }
}
