///**
// * FileName: GlobalExceptionHandler
// * Author:   13235
// * Date:     2019/1/9 20:47
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//
//package com.example.demo.config;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈〉
// *
// * @author 13235
// * @create 2019/1/9
// * @since 1.0.0
// */
////HandlerExceptionResolver ResponseEntityExceptionHandler
//@ControllerAdvice
//@RestController
//public class GlobalExceptionHandler {
//
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    public String handlerException() {
//        return "发生了错误！";
//    }
//    @ExceptionHandler(Throwable.class)
//    @ResponseStatus(code = HttpStatus.NOT_FOUND)
//    public String handlerException2() {
//        return "没有发现！";
//    }
//
//}
