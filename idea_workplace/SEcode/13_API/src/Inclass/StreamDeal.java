package Inclass;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDeal {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("马修");
        arr.add("咕哒子");
        arr.add("夏洛克");
        arr.add("芙芙");
        arr.add("贞德");
        arr.add("阿尔托莉雅");
        arr.add("Alter贞德");
        arr.add("玉藻前");
        arr.add("伊斯塔尔");
        ArrayList<String> arr2 = new ArrayList<>();
        for (String s : arr) {
            if(s.length()==3){
                arr2.add(s);

            }
        }
        Stream<String> sm1 = arr.stream().filter((name) -> name.length() == 3);
        ArrayList<String> list = new ArrayList<>();
        list.add("尼禄");
        list.add("尼托克里斯");
        list.add("始皇帝");
        list.add("伊凡雷帝");
        list.add("cc");
        ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list2.add(list.get(i));

        }
        Stream<String> sm2 = list.stream().limit(3);
        ArrayList<String> all = new ArrayList<>();
        all.addAll(arr2);
        all.addAll(list2);
        Stream<String> as = Stream.concat(sm1, sm2);
        Stream<Herolist> herolistStream = as.map((name) -> new Herolist(name));
        ArrayList<Herolist> result = new ArrayList<>();
        for (String s : all) {
            result.add(new Herolist(s));

        }
        System.out.println(result);
        herolistStream.forEach((p)->{
            System.out.print(p);
        });

    }
}
