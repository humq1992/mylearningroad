package com;

import java.util.Calendar;

public class weekday {
    public static void main(String[] args) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,2018);
        c.set(Calendar.MONTH,1);
        c.set(Calendar.DATE,14);
        int i = c.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println("星期" + i);

    }
}
