/**
 * FileName: ReceivesMsgImpl
 * Author:   13235
 * Date:     2019/7/22 23:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 *//*


package com.example.demo.services.impl;

import com.example.demo.entity.User;
import com.example.demo.services.ReceivesMsg;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

*/
/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/7/22
 * @since 1.0.0
 *//*

@Service
@Slf4j
public class ReceivesMsgImpl implements ReceivesMsg {

    @RabbitListener(queues = {"queue-01"})
    @RabbitHandler
    @Override
    public void callMsg(Message message, Channel channel, @Payload User user) {
        MessageProperties messageProperties = message.getMessageProperties();
        try {
            String s = user.toString();
            log.info("接收的消息是:" + s);
            //channel.basicAck(messageProperties.getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
