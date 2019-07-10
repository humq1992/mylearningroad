package test02;

import java.util.Objects;

/*1. 定义"学生"类,Student,包含以下成员:

成员属性: name (姓名):String类型，chinese(语文):int类型，math(数学):int类型，属性使用private修饰。

        （1）生成所有属性的get/set方法，生成构造方法

        （2）成员方法：void show()方法,打印对象所有属性的值以及对象的语文和数学成绩的总和到控制台;

 */
public class Student {
    private String name;
    private int chinese;
    private int math;

    public Student() {
    }

    public Student(String name, int chinese, int math) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
    }
    public void show(){
        System.out.println(this.name+"的语文成绩："+this.chinese+",数学成绩："+this.math+",总成绩："+(this.math+this.chinese));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", chinese=" + chinese +
                ", math=" + math +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return chinese == student.chinese &&
                math == student.math &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, chinese, math);
    }
}
