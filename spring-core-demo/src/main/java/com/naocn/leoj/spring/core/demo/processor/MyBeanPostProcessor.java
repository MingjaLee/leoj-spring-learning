package com.naocn.leoj.spring.core.demo.processor;

import com.naocn.leoj.spring.core.demo.beans.Leaf;
import com.naocn.leoj.spring.core.demo.beans.Tree2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Leaf) {
            System.out.println("MyBeanPostProcessor-beforeInit: leaf " + ((Leaf) bean).getName());
        } else if (bean instanceof Tree2) {
            System.out.println("MyBeanPostProcessor-beforeInit: tree2 " + ((Tree2) bean).toString());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Leaf) {
            System.out.println("MyBeanPostProcessor-afterInit: leaf " + ((Leaf) bean).getName());
        } else if (bean instanceof Tree2) {
            System.out.println("MyBeanPostProcessor-afterInit: tree2 " + ((Tree2) bean).toString());
        }
        return bean;
    }
}
