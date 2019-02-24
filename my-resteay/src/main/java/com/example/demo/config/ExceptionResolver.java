/**
 * FileName: ExceptionResolver
 * Author:   13235
 * Date:     2019/1/10 2:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.config;

import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/10
 * @since 1.0.0
 */
@Component
@Provider
public class ExceptionResolver implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
      /*  if (e instanceof RuntimeException) {
            return Response.ok("统一异常处理!").status(Response.Status.OK).build();
        }*/
        return Response.ok(e.getMessage()).build();
    }
}
