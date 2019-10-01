/**
 * FileName: BeanWithInject
 * Author:   13235
 * Date:     2019/7/28 20:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.json.jacksoninject;

import com.fasterxml.jackson.annotation.JacksonInject;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/7/28
 * @since 1.0.0
 */
public class BeanWithInject {
    @JacksonInject
    public int id;
    public String name;
}
