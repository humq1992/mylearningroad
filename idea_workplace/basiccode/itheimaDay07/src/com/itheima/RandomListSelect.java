package com.itheima;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomListSelect {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        Random r=new Random();
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(100)+1;
            list.add(num);
        }
        System.out.println(list);
        for (int i = list.size()-1; i >=0; i--) {
            int a = list.get(i);
            //选择条件
            if(a%2!=0){
                list.remove(i);
            }
        }
        System.out.println(list);

    }
}
