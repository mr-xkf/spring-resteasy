/**
 * FileName: MyException
 * Author:   13235
 * Date:     2019/1/28 22:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.exception;

import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/28
 * @since 1.0.0
 */
@Component
public class MyException extends RuntimeException {
    private String msg;
    private Integer code=200;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public MyException(Integer code,String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException() {
        super();
    }
}
