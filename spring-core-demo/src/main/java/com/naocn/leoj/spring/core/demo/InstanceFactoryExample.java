package com.naocn.leoj.spring.core.demo;

import com.naocn.leoj.spring.core.demo.beans.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceFactoryExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/instance-factory-bean.xml");
        AccountService service = context.getBean("accountService", AccountService.class);
        service.sayHello();
    }
}
