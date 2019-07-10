package inclass.nonameclass;

public class MainAnimal {
    public static void main(String[] args) {
        IAnimal cat=new IAnimal() {
            @Override
            public void eat() {
                System.out.println("铲屎官在哪");
            }
        };
        cat.eat();
    }
}
