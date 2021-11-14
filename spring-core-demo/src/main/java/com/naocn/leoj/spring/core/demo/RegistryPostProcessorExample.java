package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistryPostProcessorExample {
    @Configuration
    @ComponentScan("com.naocn.leoj.spring.core.demo.processor")
    static class Config {

    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Leaf leaf = context.getBean("leaf", Leaf.class);
        leaf.sayHello();

        SimpleDateFormat myTestBean = context.getBean("defaultDateFormat", SimpleDateFormat.class);
        System.out.println( "now time --- "+ myTestBean.format(new Date()));
//
//        // <alias> example
//        Leaf leaf1 = context.getBean("leaf1", Leaf.class);
//        leaf1.sayHello();
    }
}
