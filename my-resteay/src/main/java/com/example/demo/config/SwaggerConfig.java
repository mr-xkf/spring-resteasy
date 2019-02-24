///**
// * FileName: SwaggerConfig
// * Author:   13235
// * Date:     2019/1/11 0:16
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//
//package com.example.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author 13235
// * @create 2019/1/11
// * @since 1.0.0
// */
//@EnableSwagger2
//@Configuration
//public class SwaggerConfig {
//
//
//
//    @Bean
//    public Docket createDocket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo()).select().paths(PathSelectors.regex("/rest/*")).apis(RequestHandlerSelectors.basePackage("com.example.demo.contoller")).build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("开发demo").description("我的swagger")
//                .version("V1.0").contact(new Contact("xkf", "http://myxkf.com", "xkfmailbox@163.com")).license("xxxx").licenseUrl("xxx.com").build();
//    }
//
//}
