package test02;

public class programmer extends Employer {
    public programmer(String name, String num, int salery) {
        super(name, num, salery);
    }
    public void show(){
        System.out.println();
        System.out.print("Programmer:");
        super.show();
    }
}
