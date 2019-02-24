/**
 * FileName: downLoadService
 * Author:   13235
 * Date:     2019/1/27 16:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.utils.ExportUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/27
 * @since 1.0.0
 */
public class DownLoadService implements Runnable {

    private AsyncContext asyncContext;

    public DownLoadService(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    public void downLoad(AsyncContext asyncContext) {
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
        String fileName = "测试下载";
        HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
        try {
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8") + ".xlsx");
            response.setContentType("application/octet-stream");
            ServletOutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            //response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //asyncContext.complete();
            workbook.dispose();
        }
    }




    @Override
    public void run() {
        this.downLoad(asyncContext);
    }
}
