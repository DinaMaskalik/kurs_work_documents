package it.academy.utils;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class WebDocumentInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();

        context.register(WebDocumentConfiguration.class);

        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(context);

        final ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
