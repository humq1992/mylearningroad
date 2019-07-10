package inclass;

public class demo01cat {
    public static void main(String[] args) {
        cat mimi=new cat("二狗",18);
        System.out.println("姓名："+mimi.name+"  年龄："+mimi.age);
        mimi.setAge(12);
        mimi.setName("偶还有");
        System.out.println("姓名："+mimi.name+"  年龄："+mimi.age);
        cat tity1=mimi;
        System.out.println(tity1);
        System.out.println("姓名："+tity1.name+"  年龄："+tity1.age);
        System.out.println(tity1.name);
        System.out.println(tity1.getName());
        System.out.println(tity1.getAge());
    }
}
