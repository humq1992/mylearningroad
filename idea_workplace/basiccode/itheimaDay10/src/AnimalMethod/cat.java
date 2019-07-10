package AnimalMethod;

public class cat extends Animal {
    String name="喵星人";
    int age=18;

    @Override
    public void eat() {
        System.out.println("喵星人吃鱼");
    }
    public void maimeng(){
        System.out.println("喵星人特有技能卖萌");
    }
}
