package Inclass;

public class manbuilder {
    public static void main(String[] args) {
        method("赵日天",Herolist::new);
    }
    public static  void method(String s,myinter in){
        Herolist hl=in.method(s);
        System.out.println(hl);

    }
}
