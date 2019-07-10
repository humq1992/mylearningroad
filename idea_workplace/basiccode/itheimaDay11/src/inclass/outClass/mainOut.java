package inclass.outClass;

public class mainOut {
    public static void main(String[] args) {
        outclass.innner in=new outclass().new innner();
        in.diaoyong();
        System.out.println(in.num);
        System.out.println("===============");
        outclass o=new outclass();
        o.outmethod();
    }
}
