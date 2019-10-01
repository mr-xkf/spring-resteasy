/**
 * FileName: ValidatorUtils
 * Author:   13235
 * Date:     2019/1/28 22:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

import com.example.demo.exception.MyException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/28
 * @since 1.0.0
 */
public class ValidatorUtils {


    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static void validator(Object o, Class<?>... c) {
        Set<ConstraintViolation<Object>> validate = validator.validate(o, c);
        if (!validate.isEmpty()) {
            Iterator<ConstraintViolation<Object>> iterator = validate.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation<Object> next = iterator.next();
                throw new MyException(412, next.getMessage());
            }
        }
    }
}
