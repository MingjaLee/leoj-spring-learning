package com.naocn.leoj.spring.mvcextend.demo.annotation;

import com.naocn.leoj.spring.mvcextend.demo.configuration.WebConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({WebConfiguration.class})
public @interface EnableWeb {
}
