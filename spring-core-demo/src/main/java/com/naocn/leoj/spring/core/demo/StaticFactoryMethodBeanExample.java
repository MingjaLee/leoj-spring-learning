package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.ClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaticFactoryMethodBeanExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/static-factory-bean.xml");
        ClientService clientService = context.getBean("clientService", ClientService.class);
        clientService.sayHello();
    }
}
