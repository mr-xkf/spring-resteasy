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

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
     */
    public static final String MY_QUEUE_HELLO = "myQueue.hello";

    /**
     * 交换机
     */
    public static final String HELLO_EXCHANGE = "helloExchange";

    /**
     * 路由键
     */
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

}
