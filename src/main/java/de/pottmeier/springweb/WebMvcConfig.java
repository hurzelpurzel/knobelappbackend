package de.pottmeier.springweb;


import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@Configuration
@EnableWebMvc
// refer to contoller
@ComponentScan( basePackages = {"de.pottmeier.controller"})

public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
     /*   
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
        if (!registry.hasMappingForPattern("/images/**")) {
            registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
        }
        if (!registry.hasMappingForPattern("/css/**")) {
            registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
        }
        if (!registry.hasMappingForPattern("/js/**")) {
            registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        }
        if (!registry.hasMappingForPattern("/app/**")) {
            registry.addResourceHandler("/app/**").addResourceLocations("classpath:/app/");
        }
        if (!registry.hasMappingForPattern("/node_modules/**")) {
            registry.addResourceHandler("/node_modules/**").addResourceLocations("classpath:/node_modules/");
        }
        if (!registry.hasMappingForPattern("/bootstrap/**")) {
            registry.addResourceHandler("/bootstrap/**").addResourceLocations("classpath:/bootstrap/");
        }
       
  */
        
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
   

   
   @Bean ViewResolver jspViewResolver() {
   // The view names matches the name of the jsps, i guess
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(1);
   
        return viewResolver;
   }  

    

   

    
    
   
}
