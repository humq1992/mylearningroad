package com.itheima;

import java.util.ArrayList;

public class StudentArraylist {
    public static void main(String[] args) {
        ArrayList<student> list=new ArrayList<>();
        student one=new student("路人甲",18,"小学");
        student two=new student("小兵乙",18,"大专");
        student three=new student("群众丁",18,"大学");
        list.add(one);
        list.add(two);
        list.add(three);
        for (int i = 0; i < list.size(); i++) {
            student stu = list.get(i);
            System.out.println("学生姓名："+stu.getName()+"  "+"年龄："+stu.getAge());
        }


    }
}
