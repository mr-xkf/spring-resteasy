package com.example.demo.services;

import com.example.demo.entity.User;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

public interface ReceivesMsg {

    /**
     *
     * @param message
     * @param channel
     * @param user
     */
    void callMsg(Message message, Channel channel, User user);


}
