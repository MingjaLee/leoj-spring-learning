package com.naocn.leoj.spring.core.demo.config;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import com.naocn.leoj.spring.core.demo.beans.Tree;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Leaf leaf() {
        Leaf leaf = new Leaf();
        leaf.setName("green");
        return leaf;
    }

    @Bean
    public Tree tree(Leaf leaf) {
        Tree tree = new Tree();
        tree.setLeaf(leaf);
        return tree;
    }
}
