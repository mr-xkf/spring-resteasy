package com.example.demo.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
@Component
public class RestConfig extends Application {

    @Value("${spring.jersey.application-path:null}")
    private String jerseyPath;
    @Value("${server.context-path:null}")
    private String contextPath;
    public RestConfig() {
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(ApiListingResource.class);
        resources.add(SwaggerSerializers.class);
        return resources;
    }

    @PostConstruct
    public void init() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("标题");
        beanConfig.setDescription("描述");
        beanConfig.setTermsOfServiceUrl("联系服务地址");
        beanConfig.setContact("联系方式");
        beanConfig.setLicense("证书");
        beanConfig.setLicenseUrl("证书地址");
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http", "https"});
        beanConfig.setBasePath(contextPath+jerseyPath);
        beanConfig.setResourcePackage("com.example.demo.contoller");
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);
    }

}
