package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LiveDays {
    public static void main(String[] args) throws ParseException {
       String nowTime="2019年4月16日";
       String birthTime="1994年5月18日";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年mm月dd日");
        Date t1 = sdf.parse(nowTime);
        Date t2 = sdf.parse(birthTime);
     String a1 = sdf.format(t1);
     System.out.println(a1);
        long day = (t1.getTime() - t2.getTime()) / (1000 * 60 * 60 * 24);
//        System.out.println("day = " + day);
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,1994);
        c.set(Calendar.MONTH,5-1);
        c.set(Calendar.DATE,18);
        int i = c.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println("星期 " + i);

        System.out.println("=================" );
        int i1=123;
        String str1="1234534";
        int i2 = Integer.parseInt(str1);
        System.out.println(i2+i1);
        System.out.println(Long.MAX_VALUE);
    }

    
        
    
}
