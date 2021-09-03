package com.naocn.leoj.spring.core.demo.config;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import com.naocn.leoj.spring.core.demo.beans.Tree2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIConfig {
    @Bean
    public Leaf leaf() {
        Leaf leaf = new Leaf();
        leaf.setName("green");
        return leaf;
    }

    @Bean
    public Tree2 tree2() {
        return new Tree2();
    }
}
