package AnimalMethod;

public class dog extends Animal{
    String name="汪星人";
    int age=19;

    @Override
    public void eat() {
        System.out.println("汪星人啥都不吃");

    }
    public void kanmen(){
        System.out.println("傻了吧 老子会看门");
    }
}
