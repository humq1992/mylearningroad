package com.demo.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class QueueConsumer {
    @JmsListener(destination = "itcast")
    public void readMessage(String text){
        System.out.println(text);
    }
    @JmsListener(destination = "map")
    public void readMap(Map map){//此处获得的参数为上面destination中的内容
        System.out.println(map);

    }

}
