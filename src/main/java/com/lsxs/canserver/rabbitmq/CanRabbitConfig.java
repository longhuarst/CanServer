package com.lsxs.canserver.rabbitmq;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CanRabbitConfig {

    @Bean
    public Queue canStoreQueue(){
        return new Queue("canStoreQueue", true);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("canStoreExchange");
    }

    @Bean
    public Binding bindingCan(){
        return BindingBuilder.bind(canStoreQueue()).to(topicExchange()).with("can.key");
    }




}
