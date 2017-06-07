/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pottmeier.springweb;

import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author ludger
 */
@Configuration
@ComponentScan(basePackages = {"de.pottmeier.beans"})
public class RootConfig {
	
  //@Bean public SomeClass someClass() { 
  //    return someInstance;
  // }
   
    
}
