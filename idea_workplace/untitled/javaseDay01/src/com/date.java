package com;

import java.text.SimpleDateFormat;
import java.util.Date;

public class date {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Date d=new Date(time);
        System.out.println(d);
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
        System.out.println(s.format(time));

    }
}
