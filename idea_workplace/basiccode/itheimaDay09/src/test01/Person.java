package test01;

public class Person {
    private String name;
    private int age;
    private String gender;
    private String nationality;
    public void eat(){
        System.out.println("吃饭");
    }
    public  void sleep(){
        System.out.println("睡觉");
    }
    public void work(){
        System.out.println("工作");
    }

    public Person(String name, int age, String gender, String nationality) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
