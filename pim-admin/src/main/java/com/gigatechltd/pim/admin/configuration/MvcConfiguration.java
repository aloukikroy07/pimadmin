package com.gigatechltd.pim.admin.configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
//        viewControllerRegistry.addViewController("/").setViewName("redirect:/dashboard");
//    }

}
