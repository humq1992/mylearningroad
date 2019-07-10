package phoneclass;

public class test {
    public static void main(String[] args) {
        Phone iphone1=new OldPhone();
        method(iphone1);
       Phone iphone=new NewPhone();
       method(iphone);

    }
    public static void method(Phone phone){
        if(phone instanceof OldPhone){
            OldPhone op=(OldPhone)phone;
            op.call();
            op.message();
        }
        if(phone instanceof NewPhone){
            NewPhone np=( NewPhone)phone;
            np.call();
            np.message();
            np.play();
        }


    }
}
