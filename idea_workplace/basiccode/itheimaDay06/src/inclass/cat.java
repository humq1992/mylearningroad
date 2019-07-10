package inclass;

public class cat {
    String name;
    int age;

    public cat() {
        System.out.println("无参数");
    }

    public cat(String name, int age) {
        this.age = age;
        this.name = name;
        System.out.println("全参数");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
