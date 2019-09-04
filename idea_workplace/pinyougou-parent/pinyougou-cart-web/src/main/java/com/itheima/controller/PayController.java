package com.itheima.controller;

import com.itheima.SaveResult;
import com.itheima.pojo.TbPayLog;
import com.itheima.service.OrderService;
import com.itheima.service.WeixinPayService;
import com.itheima.utils.IdWorker;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pay")
public class PayController {
    @Reference
    private WeixinPayService weiXinPayService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/createNative")
    public Map createNative(){
        String userid = SecurityContextHolder.getContext().getAuthentication().getName();
        TbPayLog payLog = orderService.searchPayLogFromRedis(userid);
if(payLog!=null){

        return weiXinPayService.createNative(
                payLog.getOutTradeNo(),payLog.getTotalFee()+"");
            }else {return new HashMap();}

    }

    @RequestMapping("/queryPayStatus")
    public SaveResult queryPayStatus(String out_trade_no){

        SaveResult saveResult=null;
        int i=0;
        while (true){
            Map map = weiXinPayService.queryPayStatus(out_trade_no);
            if (map==null){
                saveResult=new SaveResult("支付错误",false);
                break;
            }
            if (map.get("trade_state").equals("SUCCESS")){
                saveResult=new  SaveResult( "支付成功",true);
                //修改订单状态
                orderService.updateOrderStatus(out_trade_no, map.get("transaction_id")+"");
                break;

            }
            if(i>100){
                saveResult=new SaveResult("支付超时",false);
                break;
            }
            i++;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return saveResult;
    }

    }
