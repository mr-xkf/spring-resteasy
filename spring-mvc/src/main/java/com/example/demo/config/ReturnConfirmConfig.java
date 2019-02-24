/**
 * FileName: ReturnConfirmConfig
 * Author:   13235
 * Date:     2019/2/19 23:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 〈一句话功能简述〉<br> 
 * 启动消息失败返回  比如路由不到队列时触发回调
 *
 * @author 13235
 * @create 2019/2/19
 * @since 1.0.0
 */
@Component
public class ReturnConfirmConfig implements RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setReturnCallback(this);
    }



    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("消息主体:" + message);
        System.out.println("响应码:" + i);
        System.out.println("描述"+s);
        System.out.println("交换机:" + s1);
        System.out.println("路由键:" + s2);
    }
}
