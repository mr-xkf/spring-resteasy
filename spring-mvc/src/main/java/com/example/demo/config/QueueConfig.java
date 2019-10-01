/**
 * FileName: QueueConfig
 * Author:   13235
 * Date:     2019/2/18 22:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/2/18
 * @since 1.0.0
 */
@Configuration
public class QueueConfig {

    /**
     * 队列
     *//*
    public static final String MY_QUEUE_HELLO = "queue-01";

    *//**
     * 交换机
     *//*
    public static final String HELLO_EXCHANGE = "helloExchange";

    *//**
     * 路由键
     *//*
    public static final String ROUTING_KEY = "hello.*";


    @Bean
    public Queue sendQueue() {
        return new Queue(MY_QUEUE_HELLO, true);
    }

    @Bean
    public Exchange helloExchange() {
        return ExchangeBuilder.topicExchange(HELLO_EXCHANGE).build();
    }

    @Bean
    public Binding bindKey() {
        return BindingBuilder.bind(sendQueue()).to(helloExchange()).with(ROUTING_KEY).noargs();
    }
*/
    @Bean
    public Queue queue01() {
        Map<String, Object> map = new HashMap<>();
        map.put("x-dead-letter-exchange", "dlx-exchange");
        map.put("x-dead-letter-routing-key", "dlx.a");
        map.put("x-message-ttl", 3000);
        return new Queue("queue-01", true,false,false,map);
    }

    @Bean
    public Queue dlxQueue() {
        return new Queue("dlx-queue", true);
    }


    @Bean
    public Exchange dlxExchange() {
        return ExchangeBuilder.directExchange("dlx-exchange").durable(true).ignoreDeclarationExceptions().build();
    }

    @Bean
    public Exchange topicExchange() {
        return ExchangeBuilder.topicExchange("helloExchange").durable(true).ignoreDeclarationExceptions().build();
    }


    @Bean
    public Binding binding() {
        return BindingBuilder.bind(dlxQueue()).to(dlxExchange()).with("dlx.a").noargs();
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue01()).to(topicExchange()).with("hello.a").noargs();
    }


}
