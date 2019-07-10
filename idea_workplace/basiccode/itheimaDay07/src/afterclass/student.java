package afterclass;

public class student {
    String name;
    int age;
    String education;

    public student() {
    }

    public student(String name, int age,String education) {
        this.name = name;
        this.age = age;
        this.education=education;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}