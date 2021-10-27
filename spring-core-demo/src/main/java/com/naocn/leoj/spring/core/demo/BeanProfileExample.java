package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

public class BeanProfileExample {
    @Configuration
    static class ProfileConfig {
        @Bean
        @Profile("blue")
        public Leaf blueLeaf() {
            Leaf leaf = new Leaf();
            leaf.setName("blue leaf");
            return leaf;
        }

        @Bean
        @Profile("green")
        public Leaf greenLeaf() {
            Leaf leaf = new Leaf();
            leaf.setName("green leaf");
            return leaf;
        }

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.getEnvironment().setActiveProfiles("green");
        context.getEnvironment().setActiveProfiles("blue");
        context.register(ProfileConfig.class);
        context.refresh();
        Leaf leaf = context.getBean(Leaf.class);
        leaf.sayHello();
    }
}
