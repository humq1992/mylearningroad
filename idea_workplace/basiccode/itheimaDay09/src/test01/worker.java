package test01;

public class worker extends Person {
    private String unit;
    private int workAge;

    public worker(String name, int age, String gender, String nationality, String unit, int workAge) {
        super(name, age, gender, nationality);
        this.unit = unit;
        this.workAge = workAge;
    }
    @Override
    public void work(){
        System.out.println("工人的工作是盖房子");

    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }
}
