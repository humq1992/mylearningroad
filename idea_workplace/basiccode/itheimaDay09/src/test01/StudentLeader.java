package test01;

public class StudentLeader extends Student {
    private String job;

    public StudentLeader(String name, int age, String gender, String nationality, String school, String schoolNumber, String job) {
        super(name, age, gender, nationality, school, schoolNumber);
        this.job = job;
    }
    public void meeting(){
        System.out.println("学生会喜欢开会");
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
