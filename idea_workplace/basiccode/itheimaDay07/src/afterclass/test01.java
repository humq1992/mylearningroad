package afterclass;


import java.util.ArrayList;

/*1.创建Student类，包含如下属性(姓名,年龄,学历) 写一个标准的Student类, 要求如下:
        private私有成员变量
        无参数构造方法 和 有参数构造方法
        getter/setter

        2.在测试类中，创建3个Student对象，将对象存入集合中。
        小红      12      小学
        小米      21      大学
        小明      14      初中

        3.遍历集合，将年龄小于15的人的学历改为幼儿园。

        4.在控制台上打印对象信息（格式：小五-20-高中）
*/
public class test01 {
    public static void main(String[] args) {
        student one = new student("小红", 12, "小学");
        student two = new student("小米", 21, "大学");
        student three = new student("小明", 14, "初中");
        ArrayList<student> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        for (int i = 0; i < list.size(); i++) {
            student stu = list.get(i);


            if (stu.age <= 15) {
                stu.education = "幼儿园";
                list.set(i, stu);

            }
        }
        for (int i = 0; i < list.size(); i++) {
            student stu2 = list.get(i);
            System.out.println(stu2.name + "-" + stu2.age + "-" + stu2.education);
        }
    }
}
