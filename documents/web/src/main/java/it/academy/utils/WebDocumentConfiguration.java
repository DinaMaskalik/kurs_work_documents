package it.academy.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "it.academy")
public class WebDocumentConfiguration implements WebMvcConfigurer {

    @Bean
    InternalResourceViewResolver internalResourceViewResolver(){

        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();

        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("/WEB-INF/jsp/");

        return viewResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp("/WEB-INF/jsp/", ".jsp");
//
//    }

//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
}
