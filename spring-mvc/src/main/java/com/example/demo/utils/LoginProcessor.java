/**
 * FileName: LoginProcessor
 * Author:   13235
 * Date:     2019/3/8 11:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/8
 * @since 1.0.0
 */
public class LoginProcessor extends AbstractLinkProcessor {

    @Override
    public void doProcess(String content) {
        System.out.println("login "+content);
    }
}
