package com.itheima.web;



import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConversion implements Converter<String,Date> {


@Override
    public Date convert(String source) {
        if(source==null){
            throw new RuntimeException("传入数据");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return sdf.parse(source);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}
