package com.tutorialspoint.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class ZuulserverApplication {
   public static void main(String[] args) {
      SpringApplication.run(ZuulserverApplication.class, args);
   }
   @Bean
   public WebMvcConfigurer corsConfigurer() {
       return new WebMvcConfigurer() {
           public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/danh-muc-dung-chung/**")
                       .allowedOrigins("http://localhost")
                       .allowedMethods("GET","POST");
           }
       };
   }
}