package afterclass;


import java.util.ArrayList;

/*2.在测试类中，创建4个对象，将对象存入集合中。
        华为-1200-4
        苹果-9000-1
        锤子-3000-3
        小米-1800-2

3.遍历集合，将使用年限小于等于2并且价格低于2000的手机打印出来  格式：华为-2000-3

4.遍历集合,删除价格大于5000的手机对象

*/
public class SecondHandPhone {
    public static void main(String[] args) {

        phone one=new phone("华为",1200,4);
        phone two=new phone("苹果",9000,1);
        phone three=new phone("锤子",3000,3);
        phone four=new phone("小米",1800,2);
        ArrayList<phone> list=new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        for (int i = 0; i < list.size(); i++) {
            phone ph=list.get(i);
            if(ph.age<=2 && ph.prize<=2000){
                System.out.println(ph.brand+"-"+ph.prize+"-"+ph.age);
            }
        }
        System.out.println("====================");
        for (int i = 0; i < list.size(); i++) {
            phone ph=list.get(i);
            if(ph.prize>=5000){
                list.remove(i);
                i--;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            phone ph=list.get(i);
            System.out.println(ph.brand+"-"+ph.prize+"-"+ph.age);
        }
    }
}
