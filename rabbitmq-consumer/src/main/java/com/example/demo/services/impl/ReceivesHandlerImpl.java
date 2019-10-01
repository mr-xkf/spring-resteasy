/**
 * FileName: ReceivesHandlerImpl
 * Author:   13235
 * Date:     2019/7/28 15:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.services.impl;

import com.example.demo.entity.User;
import com.example.demo.services.ReceivesMsg;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/7/28
 * @since 1.0.0
 */
@Service
@Slf4j
public class ReceivesHandlerImpl implements ReceivesMsg {

    @RabbitListener(queues = {"dlx-queue"})
    @RabbitHandler
    @Override
    public void callMsg(Message message, Channel channel,@Payload User user) {
        byte[] body = message.getBody();
        log.info("接收到的死信队列的消息是:" + new String(body));
    }
}
