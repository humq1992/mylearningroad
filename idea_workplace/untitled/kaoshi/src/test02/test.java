package test02;

import java.util.ArrayList;

/*定义类：Test,类中定义main()方法，按以下要求编写代码:

（1）定义如下方法：

①定义public static ArrayList<Student>  getSum(ArrayList<Student> list){...}方法:

  ②要求：遍历list集合，将list中语文成绩和数学成绩的总和大于160分的元素存入到另一个ArrayList<Student> 中并返回。

（2）分别实例化三个Student对象，三个对象分别为："邓超" ,88,99、"baby" ,85,78、"郑凯" ,86,50;

（3）创建一个ArrayList集合，这个集合里面存储的是Student类型，分别将上面的三个Student对象添加到集合中，调用方法getSum，
根据返回的list集合遍历对象并调用show（）方法输出所有元素信息。

示例如下：*/
public class test {
    public static void main(String[] args) {
        ArrayList<Student>list=new ArrayList<>();
        Student stu1=new Student("邓超",88,99);
        Student stu2=new Student("baby",85,78);
        Student stu3=new Student("郑凯",86,50);
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        ArrayList<Student> list2 = getSum(list);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i).toString());
        }


    }
    public static ArrayList<Student> getSum(ArrayList<Student> list){
        ArrayList<Student> listtemp=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getMath()+list.get(i).getChinese()>=160){
                listtemp.add(list.get(i));
            }

        }
        return listtemp;
    }
}
