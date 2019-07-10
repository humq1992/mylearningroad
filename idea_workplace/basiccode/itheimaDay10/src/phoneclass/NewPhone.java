package phoneclass;

public class NewPhone extends Phone implements IPlay {

    @Override
    public void play() {
        System.out.println("新手机玩游戏");
    }

    @Override
    public void call() {
        System.out.println("新手机打电话");
    }

    @Override
    public void message() {
        System.out.println("新手机发短信");
    }
}
