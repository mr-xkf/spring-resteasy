/**
 * FileName: Main2
 * Author:   13235
 * Date:     2019/3/8 11:20
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
public class Main2 {
    public static void main(String[] args) {
        LinkedProcessorChain chain = new LinkedProcessorChain();
        chain.addLast(new AuthProcessor());
        chain.addLast(new LoginProcessor());
        chain.addLast(new LogProcessor());
        chain.process("请求来了。。。。");
    }

}
