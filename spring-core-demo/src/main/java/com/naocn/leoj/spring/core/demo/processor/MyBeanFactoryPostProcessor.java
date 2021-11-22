package com.naocn.leoj.spring.core.demo.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(">> MyBeanFactoryPostProcessor start");
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            if (name.equals("leaf")){
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
                MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
                propertyValues.add("name","change to Red");
            }
        }
        System.out.println(">> MyBeanFactoryPostProcessor end");

    }
}
