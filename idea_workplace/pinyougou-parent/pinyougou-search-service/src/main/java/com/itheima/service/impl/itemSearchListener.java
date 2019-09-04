package com.itheima.service.impl;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.TbItem;
import com.itheima.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.List;

@Component
public class itemSearchListener implements MessageListener {
    @Autowired
    private SearchService searchService;


    @Override
    public void onMessage(Message message) {
        System.out.println("监听信息："+message);


        try {
            //将message强转
            TextMessage textMessage=(TextMessage)message;
            String text = textMessage.getText();
            List<TbItem> itemList= JSON.parseArray(text,TbItem.class);

            searchService.importList(itemList);
            } catch (JMSException e) {
            e.printStackTrace();
        }


    }
}
