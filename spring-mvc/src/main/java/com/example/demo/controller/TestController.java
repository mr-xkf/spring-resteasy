/**
 * FileName: TestController
 * Author:   13235
 * Date:     2019/1/27 16:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.utils.ExportUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/27
 * @since 1.0.0
 */
@Controller
public class TestController {
    ExecutorService executorService = Executors.newFixedThreadPool(8);

    @GetMapping(value = "/download")
    @ResponseBody
    public String downLoad(HttpServletRequest request, HttpServletResponse response2){
        AsyncContext asyncContext = request.startAsync();
        asyncContext.setTimeout(0L);
        executorService.submit(() -> {
            String[] titles = new String[]{"编号", "用户名称", "密码"};
            List<User> list = new ArrayList<>(1048575);
            for (int i = 0; i < 10; i++) {
                User user = new User();
                user.setUid(i + 1);
                user.setUserName("test" + i);
                int val = new Random().nextInt(i + 1);
                user.setPassword(String.valueOf(val));
                list.add(user);
            }
            SXSSFWorkbook workbook = ExportUtils.exportObj2Excel("test", titles, list, User.class);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                workbook.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String fileName = "测试下载";
            HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
            response.reset();
            try {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8") + ".xlsx");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream");
            try {
                ServletOutputStream out = response.getOutputStream();
                BufferedInputStream bis = null;
                BufferedOutputStream bos = null;
                bis = new BufferedInputStream(new ByteArrayInputStream(outputStream.toByteArray()));
                bos = new BufferedOutputStream(out);
                byte[] buff = new byte[2048];
                int bytesRead;
                while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                asyncContext.complete();
                workbook.dispose();
            }
        });
        return "哈哈";
    }

}
