package phoneExample;

public class phoneplus extends phone {
    @Override
    public void receive() {
        super.receive();
        System.out.println("显示头像");
        System.out.println("显示地区");
    }
}
