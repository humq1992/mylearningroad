package test03;

public class worker extends works{
    public worker(String name, String num) {
        super(name, num);
    }
    @Override
    public void work(){
        System.out.println("服务顾客");
    }
}
