/**
 * FileName: ReflectionUtils
 * Author:   13235
 * Date:     2019/1/20 3:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

import com.example.demo.domain.OpreateLog;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/20
 * @since 1.0.0
 */
public class ReflectionUtils {

    public static void main(String[] args) {
        OpreateLog o1 = new OpreateLog();
        o1.setId(1);
        o1.setModifyContent("xxx");
        o1.setModifyDate(new Date());
        OpreateLog o2 = new OpreateLog();
        o1.setId(1);
        o1.setModifyContent("xxx22");
        o1.setModifyDate(new Date());
        List<Map<String, Object>> maps = ReflectionUtils.compareObj2Obj(o1, o2);
        maps.forEach(map -> {
            System.out.println(map.toString());
        });

    }



    public static List<Map<String, Object>> compareObj2Obj(Object o, Object o2) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (o == null || o2 == null) {
            return null;
        }
        Class<?> clazz = o.getClass();
        Class<?> clazz2 = o2.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        Field[] declaredFields2 = clazz2.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            for (Field field : declaredFields2) {
                //属性名称相同
                if (declaredField.getName().equalsIgnoreCase(field.getName())) {
                    field.setAccessible(true);
                    declaredField.setAccessible(true);
                    try {
                        Object v1 = field.get(o);
                        Object v2 = declaredField.get(o2);
                        if (!Objects.equals(v1, v2)) {
                            Map<String, Object> map = new HashMap<>();
                            map.put("name", field.getName());
                            map.put("old", v2);
                            map.put("new", v1);
                            list.add(map);
                        }
                        break;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return list;
    }
}

