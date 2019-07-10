package test01;

public class Student extends Person {
    private String school;
    private String schoolNumber;


    public Student(String name, int age, String gender, String nationality,String school,String schoolNumber) {
        super(name, age, gender, nationality);
        this.school=school;
        this.schoolNumber=schoolNumber;
    }
    @Override
    public void work(){
        System.out.println("学生的工作是好好学习");
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }
}
