package com.lsxs.canserver.rabbitmq;


import com.lsxs.canserver.entity.CanRawData;

public interface CanRabbitService {
    public void add(CanRawData raw);
}
