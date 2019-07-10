package AnimalBark;

public class DrugDog extends Animal implements SlayDrug {


    @Override
    public void bark() {
        System.out.println("汪汪叫");
    }

    @Override
    public void eat() {
        System.out.println("狗啃骨头");
    }

    @Override
    public void slaydrug() {
        System.out.println("用鼻子侦测毒");
    }
}
