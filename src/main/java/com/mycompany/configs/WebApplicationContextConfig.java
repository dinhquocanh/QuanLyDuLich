 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.formatter.LoaihinhdulichFormatter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;




/**
 *
 * @author QUOC ANH
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages={
    
    "com.mycompany.controllers",
    "com.mycompany.repository",
    "com.mycompany.service",
    "com.mycompany.validators"
})

@EnableTransactionManagement
public class WebApplicationContextConfig  implements WebMvcConfigurer

{
     private LocalValidatorFactoryBean validator;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
            configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) 
    
    {
                registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");
                registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
    }

    @Override
    public Validator getValidator()
    {
        return validator; 
    
    }
    
   
    
     @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver()
    {
       InternalResourceViewResolver resource = new InternalResourceViewResolver();
       resource.setViewClass(JstlView.class);
       resource.setPrefix("/WEB-INF/pages/");
       resource.setSuffix(".jsp");
       
       return resource;
    }
    
    
    @Override
    public void addFormatters(FormatterRegistry registry) 
    {
        
        registry.addFormatter(new LoaihinhdulichFormatter());
    }
    
    
    
     @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
    
        return resolver;
    }
    
    
}
