/**
 * FileName: MsgController
 * Author:   13235
 * Date:     2019/2/18 22:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.controller;

import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/2/18
 * @since 1.0.0
 */
@RestController
@Slf4j
public class MsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/send")
    public void sendMsg() {
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        User user = new User();
        user.setUserName("哈哈");
        user.setUid(27);
        user.setPassword("xdfdf");
        rabbitTemplate.convertAndSend("helloExchange", "hello.a", user, message -> { message.getMessageProperties().setExpiration("5000");

        return message;},
                correlationData);
        log.info("当前时间为："+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
    }


}
