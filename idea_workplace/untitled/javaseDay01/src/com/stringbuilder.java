package com;


public class stringbuilder {
    public static void main(String[] args) {
        String[] str={"010","3223","666","7890987","123123"};
        int count=0;
        for (int i = 0; i < str.length; i++) {
            StringBuilder sb=new StringBuilder();
            sb.append(str[i]);
            String st1 = sb.reverse().toString();
            if(str[i].equals(st1)){
                count++;
            }
        }
        System.out.println(count);
    }
}
