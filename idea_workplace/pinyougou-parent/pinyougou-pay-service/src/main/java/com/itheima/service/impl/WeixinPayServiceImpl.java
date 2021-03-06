package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.wxpay.sdk.WXPayUtil;
import com.itheima.service.WeixinPayService;
import com.itheima.utils.HttpClient;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;
@Service
public class WeixinPayServiceImpl implements WeixinPayService {
    @Value("${appid}")
    private String appid;

    @Value("${partner}")
    private String partner;
    @Value("${partnerkey}")
    private String partnerkey;
    @Value("${notifyurl}")
    private String notifyurl;


    @Override
    public Map createNative(String out_trade_no, String total_fee) {

        HashMap<String, String> map = new HashMap<>();
        map.put("appid", appid);
        map.put("mch_id", partner);
        map.put("nonce_str", WXPayUtil.generateNonceStr());
        map.put("sign", partnerkey);
        map.put("body", "pinyougou");
        map.put("out_trade_no", out_trade_no);
        map.put("total_fee", total_fee);
        map.put("notify_url", notifyurl);
        map.put("spbill_create_ip", "127.0.0.1");
        map.put("trade_type", "NATIVE");


        try {

            String signedXml = WXPayUtil.generateSignedXml(map, partnerkey);

            HttpClient httpClient = new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");
            httpClient.setHttps(true);
            httpClient.setXmlParam(signedXml);
            httpClient.post();

            //3.获得结果
            String content = httpClient.getContent();
            Map<String, String> resultMap = WXPayUtil.xmlToMap(content);
            HashMap<String, String> codemap = new HashMap<>();
            codemap.put("code_url", resultMap.get("code_url"));
            codemap.put("total_fee", total_fee);
            codemap.put("out_trade_no", out_trade_no);
            return codemap;


        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap();
        }
    }

    @Override
    public Map queryPayStatus(String out_trade_no) {
        //查询逻辑几乎一致不过访问的url不同

        Map param = new HashMap();
        param.put("appid", appid);//公众账号 ID
        param.put("mch_id", partner);//商户号
        param.put("out_trade_no", out_trade_no);//订单号
        param.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串
        String url = "https://api.mch.weixin.qq.com/pay/orderquery";
        try {
            String xmlParam = WXPayUtil.generateSignedXml(param, partnerkey);
            HttpClient client = new HttpClient(url);
            client.setHttps(true);
            client.setXmlParam(xmlParam);
            client.post();
            String result = client.getContent();
            Map<String, String> map = WXPayUtil.xmlToMap(result);
            System.out.println(map);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
