/**
 * FileName: MsgConfirmConfig
 * Author:   13235
 * Date:     2019/2/19 23:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.config;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 〈一句话功能简述〉<br> 
 * 通过实现ConfirmCallback接口，消息发送到Broker后触发回调,确认消息是否到达Broker服务器
 * 也就是确认是否正确到达Exchange中
 * @author 13235
 * @create 2019/2/19
 * @since 1.0.0
 */
@Component
public class MsgConfirmConfig implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        //指定confirmCallBack
        rabbitTemplate.setConfirmCallback(this);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("消息唯一标识:" + correlationData.getId());
        System.out.println("确认结果:" + b);
        System.out.println("失败原因:" + s);


    }
}
