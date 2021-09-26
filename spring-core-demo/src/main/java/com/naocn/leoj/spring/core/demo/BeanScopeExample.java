package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import org.springframework.beans.factory.annotation.Autowired;

public class BeanScopeExample {
    static class Tree {
        @Autowired
        private Leaf leaf;
    }
}
