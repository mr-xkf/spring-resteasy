/**
 * FileName: ReceiveMsgService
 * Author:   13235
 * Date:     2019/2/19 21:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.service.serviceImpl;

import com.example.demo.config.QueueConfig;
import com.example.demo.entity.User;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/2/19
 * @since 1.0.0
 */
@Component
public class ReceiveMsgService {

    @RabbitHandler
    @RabbitListener(
            bindings = @QueueBinding(
                    exchange = @Exchange(value = "topic.exchange",  type = "topic"),
                    value = @Queue(value = QueueConfig.MY_QUEUE_HELLO, durable = "true"),
                    key = "key.#"
            ))
    public void receiveMsg(@Headers Map<String,Object> headers, @Payload User msg, Channel channel) {
        headers.forEach((k, v) -> System.out.println("key:" + k + "value:" + v));
        System.out.println(msg.toString());
    }


}
