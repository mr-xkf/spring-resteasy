/**
 * FileName: UserContoller
 * Author:   13235
 * Date:     2019/1/9 20:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.contoller;

import com.example.demo.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/9
 * @since 1.0.0
 */
@Controller
@Path("/user")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Component
@Api("用户请求类")
@Slf4j
public class UserController {



    @Path("/get/{address}")
    @GET
    @ApiResponse(response = User.class,code=200,message = "成功！")
    @ApiOperation(value="获取用户信息",notes = "参数不能有误！",httpMethod = HttpMethod.GET)
    public User getUser(@Context HttpServletRequest request,
                        @HeaderParam("id") Long id,
                        @MatrixParam("userName") String userName,
                        @QueryParam("from") String from,
                        @CookieParam("password") String password,
                        @PathParam("address") String address) {
        System.out.println("地址是：" + request.getRequestURI());
        System.out.println("headerParam:" + id);
        System.out.println("matrixParam:" + userName);
        System.out.println("queryParam:" + from);
        System.out.println("cookieParam:" + password);
        System.out.println("pathVariable:" + address);
        return new User();
    }

}
