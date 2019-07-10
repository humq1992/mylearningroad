package com;
/**
 * 定义三个数字7，8，9
 * 用StringBuilder来输出一个字符串要求
 * 字符串内每个元素数字由7，8，9组成但是不重复。例如"789,798,897,879,987,978"
                                                    789 ,897,         978,
 */

public class stringbuilderHard {
    public static void main(String[] args) {
        String s="789";
        //在字符串中通过CharAt方法索引出单个数字；
        StringBuilder sb=new StringBuilder();
        //通过两次嵌套循环
        //for(遍历数组s的长度){
        //      for(){
        //          方法体中sb.append增加索引出的数字；
        //      }
        //判断是否是最后一次遍历，是则不加空格，否则加空格。
        //然后通过字符串的功能将s的数字排列中第一个数字放到最后一位去。
        // }
        for (int i = 0; i < 3; i++) {
            for (int i1 = 0; i1 < s.length(); i1++) {
                sb.append(s.charAt(i1));

            }
            s=s.substring(1)+s.charAt(0);
            if(i!=2){
                sb.append(" ");
            }
        }
        //通过循环获得的元素只有三个，缺少了将数字反转后的元素。
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        System.out.println(sb.toString()+" "+sb.reverse().toString());

    }
}
