package com.lsxs.canserver.rabbitmq;


import com.lsxs.canserver.entity.CanRawData;
import com.lsxs.canserver.repository.CanRawDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
@RabbitListener(queues = "canStoreQueue")
public class CanRabbitListener {

    static Logger logger = LoggerFactory.getLogger(CanRabbitListener.class);



    @Autowired
    private CanRawDataRepository canRawDataRepository;


    @RabbitHandler
    public void getCanRawDataMessage(CanRawData raw){
        canRawDataRepository.save(raw);
        logger.info("store can data to sql after rabbitmq");
    }
}
