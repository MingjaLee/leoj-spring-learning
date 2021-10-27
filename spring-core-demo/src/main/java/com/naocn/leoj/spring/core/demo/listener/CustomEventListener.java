package com.naocn.leoj.spring.core.demo.listener;

import com.naocn.leoj.spring.core.demo.event.CustomApplicationEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class CustomEventListener implements ApplicationListener<CustomApplicationEvent> {

    @Override
    public void onApplicationEvent(CustomApplicationEvent event) {
        System.out.println("CustomEvent listener: " + event.getMessage());
    }
}
