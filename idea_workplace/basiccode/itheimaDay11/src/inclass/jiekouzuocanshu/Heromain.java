package inclass.jiekouzuocanshu;

public class Heromain {
    public static void main(String[] args) {
        Hero hero=new Hero();
        hero.setName("德玛西亚");
        hero.setAge(20);
        hero.setSkill(new Skill() {
            @Override
            public void use() {
                System.out.println("人在塔在");
            }
        });
        hero.attack();
    }
}
