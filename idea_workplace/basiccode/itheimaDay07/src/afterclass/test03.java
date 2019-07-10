package afterclass;
/*题目:
    1.定义一个集合 ArrayList,用于保存随机数数据,只保存 10个随机数.
    2.产生随机数,要求范围是三位数.包括100不包括1000
    3.判断当前的数据当中是否存在 3的倍数,如果出现3的倍数就删除改元素.
    4.循环遍历,最后剩余的元素数据


*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class test03 {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(900) + 100;
            list.add(num);
        }
        System.out.println(list);
//        for (int i = 0; i < list.size(); i++) {
//            int num = list.get(i);
//            if (num % 3 == 0) {
//                list.remove(i);
//                i--;
//            }
//        }
//        System.out.println(list);
        /*================方法二==================*/
        ArrayList<Integer> listed = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num % 3 != 0) {
                listed.add(num);
            }

        }
        System.out.println(listed);

    }
}
