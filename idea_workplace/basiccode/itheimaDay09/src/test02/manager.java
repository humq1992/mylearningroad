package test02;

public class manager extends Employer {
    private int award;

    public manager(String name, String num, int salery, int award) {
        super(name, num, salery);
        this.award = award;
    }
    @Override
    public void show(){
//        System.out.println();
        System.out.print("Manager:");
        super.show();
        System.out.print(":"+this.award);
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }
}
