package com.itheima.service.impl;

import com.itheima.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.util.Arrays;

@Component
public class itemSearchDeleteListener implements MessageListener {
    @Autowired
    private SearchService searchService;
    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage=(ObjectMessage)message;
        Long[] ids = new Long[0];
        try {
            ids = (Long[]) objectMessage.getObject();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        searchService.deleteByGoodsIds(Arrays.asList(ids));

    }
}
