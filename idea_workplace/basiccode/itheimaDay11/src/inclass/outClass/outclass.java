package inclass.outClass;

public class outclass {
    int num=10;
    public class innner{
        int num=20;
        public void diaoyong(){
            int num=30;
            System.out.println(num);
            System.out.println(this.num);
            //当内部类要调用外部类的成员变量 使用 外部类名称.this.变量名称
            System.out.println(outclass.this.num);
        }

    }
    public void outmethod(){
        //  用外部类的方法调用内部类的内容 需要创建一个内部类的对象，然后调用
        System.out.println("这是一个外部类的成员方法");
        innner i=new innner();
        i.diaoyong();
    }
}
