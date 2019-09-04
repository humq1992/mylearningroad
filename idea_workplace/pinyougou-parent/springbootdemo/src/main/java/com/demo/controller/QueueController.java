package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class QueueController {
    @Autowired
    private JmsTemplate jmsTemplate;
    @RequestMapping("/send")
    public void sendMessage(String text){
        //这种方式不需要创建匿名内部类
        //第一个参数为destination  第二个为信息内容
        jmsTemplate.convertAndSend("itcast",text);
    }
    @RequestMapping("/sendMap")
    public void sendMap(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("姓","王");
        map.put("名","八");

        jmsTemplate.convertAndSend("map",map);
    }
}
