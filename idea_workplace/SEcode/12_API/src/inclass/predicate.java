package inclass;

import java.util.ArrayList;
import java.util.function.Predicate;

public class predicate {
    public static ArrayList method(String[] arr, Predicate<String>pre1,Predicate<String> pre2){
        ArrayList<String> mlist = new ArrayList<String>();
        for (String s : arr) {
            boolean b = pre1.and(pre2).test(s);
            if(b==true){
                mlist.add(s);
            }
        }

        return  mlist;
    }

    public static void main(String[] args) {
      String[] arr={"古力娜扎一号，女","古力娜扎二号，男","古力娜扎三号，女","古力娜扎四号，男"};
        ArrayList<String> list = method(arr,
                (s) -> s.split("，")[0].length() ==6,
                (s) -> s.split("，")[1].equals("女"));
        for (String s : list) {
            System.out.println(s);
        }

        }


}
