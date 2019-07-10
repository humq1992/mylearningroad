package inclass.jiekouzuocanshu;

public class Hero {
    private String name;
    private int age;
    private  Skill skill;

    public Hero() {
    }

    public Hero(String name, int age, Skill skill) {
        this.name = name;
        this.age = age;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
    public void attack(){
        System.out.println("我叫"+getName()+",今年"+getAge());
        skill.use();
    }
}
