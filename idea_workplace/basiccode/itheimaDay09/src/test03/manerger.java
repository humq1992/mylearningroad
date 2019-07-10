package test03;

public class manerger extends works{
    private int award;


    public manerger(String name, String num, int award) {
        super(name, num);
        this.award = award;
    }
    @Override
    public void work(){
        System.out.println("管理员工");
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }
}