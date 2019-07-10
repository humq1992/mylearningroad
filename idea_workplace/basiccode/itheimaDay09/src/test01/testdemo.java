package test01;

public class testdemo {
    public static void main(String[] args) {
        Student student=new Student("尼古拉斯·赵四",18,"男","中国乡村","村委版街舞学院","A1230932");
        student.work();
        worker wor=new worker("宇智波刘能",18,"男","日本","木叶忍村村办安全委员会",10);
        wor.work();
        StudentLeader SL=new StudentLeader("萧学狄",14,"不明","火星","枫叶学院","SB12580","超能力同盟会会长");
        SL.meeting();
        SL.setName("大兄弟");
        System.out.println(SL.getName());
        System.out.println(student.getName());
    }
}
