/**
 * FileName: ExportUtils
 * Author:   13235
 * Date:     2019/1/27 14:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

import com.example.demo.entity.User;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ExportUtils {

    public static SXSSFWorkbook exportObj2Excel(String sheetName, String[] titles, List<?> data, Class<?> cls) {
        SXSSFWorkbook workbook = new SXSSFWorkbook(50000);
        Sheet sheet;
        if (StringUtils.isBlank(sheetName)) {
            sheet = workbook.createSheet();
        } else {
            sheet = workbook.createSheet(sheetName);
        }
        Row row = sheet.createRow(0);
        Cell cell;
        for (int i = 0; i < titles.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(titles[i]);
        }
        int index = 1;
        for (int i = 0; i < data.size(); i++) {
            row = sheet.createRow(index++);
            Field[] declaredFields = cls.getDeclaredFields();
            for (int j = 0; j < declaredFields.length; j++) {
                cell = row.createCell(j);
                try {
                    String str = declaredFields[j].getName().substring(0, 1).toUpperCase() + declaredFields[j].getName().substring(1);
                    System.out.println(str);
                    Method m = cls.getDeclaredMethod("get"+str);
                    Object invoke = m.invoke(data.get(i));
                    String s;
                    if (ClassUtils.isPrimitiveOrWrapper(invoke.getClass())) {
                        s = String.valueOf(invoke);
                    } else if (invoke instanceof Date) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        s = simpleDateFormat.format((Date) invoke);
                    }else{
                        s = (String) invoke;
                    }
                    cell.setCellValue(s);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return workbook;
       /* FileOutputStream out;
        try {
            out = new FileOutputStream("d:" + File.separator + "sxssf.xlsx");
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        workbook.dispose();*/
    }

    public static void main(String[] args) {
        String[] titles = new String[]{"编号", "用户名称", "密码"};
        List<User> list = new ArrayList<>(1048575);
        for (int i = 0; i < 1048575; i++) {
            User user = new User();
            user.setUid(i + 1);
            user.setUserName("test" + i);
            int val = new Random().nextInt(i + 1);
            user.setPassword(String.valueOf(val));
            list.add(user);
        }
        ExportUtils.exportObj2Excel("test", titles, list, User.class);
    }

}
