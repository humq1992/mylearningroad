package com;


    public class ToStringTest{
        static int i= 1;
        public static void main(String args[]){
            ToStringTest b = new ToStringTest();
            System.out.println( "love"+b.i);
            //System.out.println方法中源代码即引用toString方法打印输出，
            //所以在new出一个新对象后不管点不点toString方法都会出现toString的返回值
            ToStringTest a = new ToStringTest();
            a.i++;
            System.out.println("me " + a.i);
        }
        public String toString(){
            System.out.print("I ");
            return "java ";
        }
    }


