/**
 * FileName: ValidatorConfig
 * Author:   13235
 * Date:     2019/1/29 0:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/29
 * @since 1.0.0
 */
@Configuration
public class ValidatorConfig {


    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor mpp = new MethodValidationPostProcessor();
        mpp.setValidator(validator());
        return mpp;
    }

    @Bean
    public Validator validator() {
        Validator validator = Validation.byProvider(HibernateValidator.class)
                .configure().failFast(true).buildValidatorFactory().getValidator();
        return validator;
    }

}
