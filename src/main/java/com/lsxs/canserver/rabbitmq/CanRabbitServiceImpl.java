package com.lsxs.canserver.rabbitmq;

import com.lsxs.canserver.entity.CanRawData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CanRabbitServiceImpl implements CanRabbitService{

    @Autowired
    private RabbitTemplate rabbitTemplate;




    @Override
    public void add(CanRawData raw) {
        rabbitTemplate.convertAndSend("canStoreQueue", raw);
    }

}
