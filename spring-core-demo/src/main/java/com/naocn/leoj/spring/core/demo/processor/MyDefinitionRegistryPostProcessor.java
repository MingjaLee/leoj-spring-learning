package com.naocn.leoj.spring.core.demo.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class MyDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("...........MyDefinitionRegistryPostProcessor.........");
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);

        // load BeanDefinitions from default xml parser
        System.out.println(".............Load spring beans xml.........");
        FileSystemResource fileSystemResource = new FileSystemResource("spring-core-demo/src/main/resources/spring/one-bean.xml");
        reader.loadBeanDefinitions(fileSystemResource);

        // load  BeanDefinitions from custom xml parser
        System.out.println(".............Load custom beans xml.........");
        fileSystemResource = new FileSystemResource("spring-core-demo/src/main/resources/spring/custom-bean.xml");
        reader.loadBeanDefinitions(fileSystemResource);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
