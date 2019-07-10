package AnimalMethod;

public class test {
    public static void main(String[] args) {
            Animal ani =new dog();
            animalmethod(ani);
    }
    public static void animalmethod (Animal ani){
        System.out.println(ani.age);
        System.out.println(ani.name);
        ani.eat();
        ani.method();
        if(ani instanceof cat){
            cat ca=(cat)ani;
            System.out.println(ca.age);
            System.out.println(ca.name);
            ca.eat();
            ca.maimeng();
        }
        if(ani instanceof dog){
            dog d=(dog)ani;
            System.out.println(d.age);
            System.out.println(d.name);
            d.eat();
            d.kanmen();
        }
    }
}
