/**
 * FileName: LogController
 * Author:   13235
 * Date:     2019/1/20 3:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.contoller;

import com.example.demo.DTO.Log.LogDTO;
import com.example.demo.domain.LogOperate;
import com.example.demo.exception.CommonResult;
import com.example.demo.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/20
 * @since 1.0.0
 */
@Controller
@Path("/log")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Component
@Api("日志操作类")
@Slf4j
public class LogController {

    @Autowired
    private LogService logService;


    @Path("/all")
    @GET
    @ApiOperation(value = "查询日志列表")
    public CommonResult findAll() {
        List<LogOperate> logList = logService.findLogList();
        return CommonResult.create(logList);
    }

    @Path("/save")
    @POST
    @ApiOperation(value = "保存日志信息")
    public CommonResult saveLog(LogOperate opreateLog)  {

        String s1="";
        try {
            Future<String>  s = logService.editLog(opreateLog);
            // s1= s.get();
            System.out.println("值为:"+s1);
        } catch (ExecutionException e) {
            log.error("线程执行错误。。。。");
            e.printStackTrace();
        } catch (InterruptedException e) {
            log.error("线程被打扰错误返回");
           Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        System.out.println("----------->"+s1);
        return CommonResult.create("保存成功！");
    }

    @Path("/delete/{id}")
    @DELETE
    @ApiOperation(value = "单条删除日志信息")
    public CommonResult deleLog(@ApiParam(value = "日志id", required = true) @PathParam("id") Long id) {
        logService.deleteLog(id);
        return CommonResult.create("删除日志为" + id + "成功！");
    }

    @PUT
    @Path("/update/userName")
    @ApiOperation(value = "修改操作人名称")
    public CommonResult updateUserName(LogDTO logDTO) {
        Assert.notNull(logDTO, "参数对象不能为空！");
        logService.updateUserName(logDTO.getUserName(), logDTO.getId());
        return CommonResult.create("修改操作人->" + logDTO.getUserName() + "\t成功！");
    }


}
