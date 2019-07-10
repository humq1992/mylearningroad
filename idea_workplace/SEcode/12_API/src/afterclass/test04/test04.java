package afterclass.test04;
/**/
public class test04 {
    public static void main(String[] args) {
        myobject mo = new myobject();
        int i = method01(mo::method);
        System.out.println(i);
    }
    public static int method01(myinterface mi){
        return  mi.print();
    }
}
