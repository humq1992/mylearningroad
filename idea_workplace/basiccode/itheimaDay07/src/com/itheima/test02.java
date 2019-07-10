package com.itheima;

import java.util.ArrayList;

public class test02 {
    public static void main(String[] args) {
        ArrayList<String> arrL=new ArrayList<>();
        arrL.add("德玛西亚");
        arrL.add("艾欧尼亚");
        arrL.add("诺克萨斯");
        arrL.add("雷瑟守备");
        System.out.println(arrL);
        arrL.remove(2);
        System.out.println(arrL);
        arrL.set(1,"暗影岛");
        System.out.println(arrL);
        for (int i = 0; i < arrL.size(); i++) {
            String str=arrL.get(i);
            System.out.println(str);
            
        }
    }
}
