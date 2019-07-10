package test02;

public class Employer {
    private String name;
    private String Num;
    private int salery;

    public void work(){
        System.out.println("穷字就是再一个地方每天卖力工作八小时");
    }
    public void show(){
        System.out.print(this.name+":");
        System.out.print(this.Num+":");
        System.out.print(this.salery);


    }

    public Employer(String name, String num, int salery) {
        this.name = name;
        Num = num;
        this.salery = salery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return Num;
    }

    public void setNum(String num) {
        Num = num;
    }

    public int getSalery() {
        return salery;
    }

    public void setSalery(int salery) {
        this.salery = salery;
    }
}
