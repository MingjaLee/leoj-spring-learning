package com.naocn.leoj.spring.core.demo.listener;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

public class ExampleListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Leaf leaf = event.getApplicationContext().getBean(Leaf.class);
        leaf.sayHello();
    }
}
