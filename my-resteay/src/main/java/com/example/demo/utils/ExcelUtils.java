/**
 * FileName: ExcelUtils
 * Author:   13235
 * Date:     2019/1/21 20:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

import com.example.demo.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 13235
 * @create 2019/1/21
 * @since 1.0.0
 */
public class ExcelUtils {

    public static void main(String[] args) {
        int size = 100000;
        User user;
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            user = new User();
            user.setId(Long.valueOf(i));
            user.setAge(23);
            user.setUserName("测试" + i);
            user.setBirthDate(new Date());
            user.setAddress("上海" + i);
            user.setPassword("sdfdsfsd");
            userList.add(user);
        }
        String[] columnName = new String[]{"编号", "年龄", "姓名", "出生日期", "居住地址", "用户密码"};
        Object[][] objects = new Object[size][columnName.length];
        int index=0;
        for (User  u : userList) {
            objects[index][0]=u.getId();
            objects[index][1] = u.getAge();
            objects[index][2]=u.getUserName();
            objects[index][3] =u.getBirthDate();
            objects[index][4]=u.getAddress();
            objects[index][5] =u.getPassword();
            index++;
        }
        XSSFWorkbook workbook = ExcelUtils.exportExcel("测试案例", "大标题", columnName, objects);
        try {
            workbook.write(new FileOutputStream(new File("d:"+File.separator+"tt.xlsx")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("执行成功!");
    }

    /**
     * 导出Excel文件
     *
     * @param sheetName
     * @param title
     * @param columnName
     * @param data
     * @return XSSFWorkbook
     */
    public static XSSFWorkbook exportExcel(String sheetName, String title, String[] columnName, Object[][] data) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = null;
        if (StringUtils.isNotBlank(sheetName)) {
            sheet = workbook.createSheet(sheetName);
        } else {
            sheet = workbook.createSheet();
        }
        int offset = 0;
        XSSFRow row = sheet.createRow(offset);
        XSSFCell cell = row.createCell(offset);
        if (StringUtils.isNotBlank(title)) {
            cell.setCellValue(title);
            offset = 1;
        }
        row = sheet.createRow(offset);
        for (int i = 0; i < columnName.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(columnName[i]);
        }
        for (int i = 0; i < data.length; i++) {
            row = sheet.createRow(++offset);
            for (int j = 0; j < columnName.length; j++) {
                cell = row.createCell(j);
                if (data[i][j] instanceof BigDecimal) {
                    cell.setCellValue(((BigDecimal) data[i][j]).doubleValue());
                } else if (data[i][j] instanceof Double) {
                    cell.setCellValue((Double) data[i][j]);
                } else if (data[i][j] instanceof Integer) {
                    cell.setCellValue((Integer) data[i][j]);
                } else if (data[i][j] instanceof Long) {
                    cell.setCellValue((Long) data[i][j]);
                } else if (data[i][j] instanceof Date) {
                    cell.setCellValue((Date) data[i][j]);
                } else if (data[i][j] instanceof Boolean) {
                    cell.setCellValue((Boolean) data[i][j]);
                } else {
                    cell.setCellValue((String) data[i][j]);
                }
            }
        }
        return workbook;
    }

}
