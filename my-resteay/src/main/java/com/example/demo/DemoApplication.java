package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableAsync
public class DemoApplication  extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }
/*
    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator creator = new BeanNameAutoProxyCreator();
        creator.setBeanNames();
        RegexpMethodPointcutAdvisor pointcutAdvisor = new RegexpMethodPointcutAdvisor();
        pointcutAdvisor.setPattern("");
        pointcutAdvisor.setAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {

            }
        });
        creator.setInterceptorNames();

        return creator;


    }*/
}

