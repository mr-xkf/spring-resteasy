/**
 * FileName: LogMark
 * Author:   13235
 * Date:     2019/1/20 4:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/20
 * @since 1.0.0
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface LogMark {


    LogType operatType() default LogType.EDIT;

    enum  LogType{
        EDIT,DELETE
        }
    }


