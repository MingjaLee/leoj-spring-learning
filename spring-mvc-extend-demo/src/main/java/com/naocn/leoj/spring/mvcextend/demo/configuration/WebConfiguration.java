package com.naocn.leoj.spring.mvcextend.demo.configuration;

import com.naocn.leoj.spring.mvcextend.demo.version.ApiVersionHandlerMapping;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

@Configuration
public class WebConfiguration {
    @Configuration
    public static class WebMvcRegistrationConfig implements WebMvcRegistrations {
        @Override
        public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
            return new ApiVersionHandlerMapping();
        }
    }


}
