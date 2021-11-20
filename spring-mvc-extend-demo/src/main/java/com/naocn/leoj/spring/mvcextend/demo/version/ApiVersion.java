package com.naocn.leoj.spring.mvcextend.demo.version;

import java.lang.annotation.*;

import org.springframework.web.bind.annotation.Mapping;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {
    /**
     * 版本号
     * @return
     */
    int value();
}
