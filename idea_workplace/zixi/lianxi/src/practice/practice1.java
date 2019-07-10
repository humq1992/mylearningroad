package practice;

import java.util.*;

/*键盘录入字符串,录入之后就向ArrayList<String>集合中存储,当录入的是”java”时,提示录入非法字符串,集合中最多只能存储5个字符串.
    录入完成后,统计该集合中每个字符（注意，不是字符串）出现的次数。
	例如：集合中有”abc”、”bcd”两个元素，
程序最终输出结果为：a(1)b(2)c(2)d(1)。

*/
public class practice1 {
    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList();
        while (arr.size()<5) {
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入字符串");
            String s = sc.nextLine();
            if(s.equals("java")){
                System.out.println("非法字符");
                continue;
            }
            arr.add(s);
        }

        Map<Character,Integer> map=new HashMap<>();
        for (String s : arr) {
            for (int i = 0; i < s.length(); i++) {
                if(map.containsKey(s.charAt(i))==false){
                    map.put(s.charAt(i),1);
                }else if (map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                }
            }
        }
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        for (Map.Entry<Character, Integer> characterIntegerEntry : set) {
            System.out.print(characterIntegerEntry.getKey()+"("+characterIntegerEntry.getValue()+")");
        }
    }
}
